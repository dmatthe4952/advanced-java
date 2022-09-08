package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Repository<T> {
	public void save(T t) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		var clazz = t.getClass();
		
		var tableName = clazz.getSimpleName().toLowerCase();
		
		var classAnnotations = clazz.getAnnotationsByType(Entity.class);
		
		if (classAnnotations.length > 0 && classAnnotations[0].value().length() > 0) {
			tableName = classAnnotations[0].value();
		}
		
		System.out.println("Table: " + tableName);
		
		var fields = clazz.getDeclaredFields();
		
		ArrayList<String> fieldList = new ArrayList<>();
				
		for(var field: fields) {
			var annotations = field.getAnnotationsByType(app.Field.class);
			
			if(annotations.length == 0) {
				continue;
			}
			
			var annotation = annotations[0];
			
			var fieldName = annotation.columnName();
			var isKey = annotation.isKey();
			
			if (fieldName.length() == 0) {
				fieldName = field.getName();
			}
			
			if(!isKey) {
				fieldList.add(fieldName);
			}
		}
		String sqlFields = fieldList.stream().collect(Collectors.joining(", "));
		String sqlPlaceHolders = fieldList.stream().map(s -> "?").collect(Collectors.joining( ", "));
		System.out.println(sqlFields);
		System.out.println(sqlPlaceHolders);
		String sql = "insert into " + tableName + " (" + sqlFields + ") values (" + sqlPlaceHolders + ") ";
		System.out.println(sql);
		
	}

}
