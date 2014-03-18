package com.nisum.eventmanager.datawriting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * this class contains the code of writing the data to target files
 * like web.xml, application context, main controller, welcome page
 */
public class DataWriting {

	FileWriter fileWriter;
	File file;
	String eventMainJsp = "ReDirectingToController.jsp";
	String[] eventRootStructure = { "WEB-INF", "META-INF" };
	String[] subWebInfStructure = { "classes", "jsp", "lib" };
	String[] subWebInfjsps = { "Success.jsp", "End.jsp" };
	String[] subClassesStructure = { "controller", "aop", "dozer",
			"interfaces", "mail", "validator", "model", "dao" };
	String[] classes = { "MainController", "Aop", "Dozer", "Interfaces",
			"Mail", "Validator", "Model", "Dao" };

	/*
	 * writing data to ReDirectingToController.jsp in target folder
	 */
	public void writingToWelcomePage(String eventManager) throws IOException {

		fileWriter = new FileWriter(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/ReDirectingToController.jsp");

		fileWriter
				.write("<jsp:forward page=\"/controller/main\"></jsp:forward>");

		fileWriter.flush();

		fileWriter.close();
	}

	/* writing xml data into target WEB.XML */
	public void writingToWebxml(String eventManager) throws IOException {

		fileWriter = new FileWriter(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/WEB-INF/web.xml");
		fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		fileWriter
				.write("<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://java.sun.com/xml/ns/javaee\" xmlns:web=\"http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\" xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\" id=\"WebApp_ID\" version=\"2.5\">");

		fileWriter.write("<display-name>" + eventManager + "</display-name >");

		fileWriter
				.write("<welcome-file-list> <welcome-file>ReDirectingToController.jsp</welcome-file> </welcome-file-list>");

		fileWriter
				.write("<context-param> <param-name>contextConfigLocation</param-name> <param-value>/WEB-INF/"
						+ eventManager
						+ "-servlet.xml</param-value>	</context-param>");

		fileWriter
				.write("<listener> <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class> </listener>");

		fileWriter
				.write(" <servlet> <servlet-name>"
						+ eventManager
						+ "</servlet-name> <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class> <load-on-startup>1</load-on-startup> </servlet>");

		fileWriter
				.write(" <servlet-mapping> <servlet-name>"
						+ eventManager
						+ "</servlet-name> <url-pattern>/</url-pattern> </servlet-mapping>");

		fileWriter.write("</web-app>");

		fileWriter.flush();

		fileWriter.close();
	}

	/*
	 * Writing the data into target application context
	 */
	public void writingToApplicationContext(String eventManager)
			throws IOException {

		fileWriter = new FileWriter(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/WEB-INF/" + eventManager
						+ "-servlet.xml");

		fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		fileWriter
				.write("<beans xsi:schemaLocation=\" http://www.springframework.org/schema/beans ");
		fileWriter
				.write("http://www.springframework.org/schema/beans/spring-beans-3.0.xsd ");
		fileWriter.write("http://www.springframework.org/schema/context ");
		fileWriter
				.write("http://www.springframework.org/schema/context/spring-context-3.0.xsd ");
		fileWriter.write("http://www.springframework.org/schema/aop ");
		fileWriter
				.write("http://www.springframework.org/schema/aop/spring-aop-3.0.xsd ");
		fileWriter.write("http://www.springframework.org/schema/mvc ");
		fileWriter
				.write("http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd ");
		fileWriter.write("http://www.springframework.org/schema/beans ");
		fileWriter
				.write("http://www.springframework.org/schema/beans/spring-beans-3.0.xsd ");
		fileWriter.write("http://www.springframework.org/schema/util ");
		fileWriter
				.write("http://www.springframework.org/schema/util/spring-util.xsd ");
		fileWriter.write("http://www.springframework.org/schema/task ");
		fileWriter
				.write("http://www.springframework.org/schema/task/spring-task-3.0.xsd \" ");

		fileWriter
				.write("xmlns:tx=\"http://www.springframework.org/schema/tx\" xmlns:p=\"http://www.springframework.org/schema/p\" xmlns:context=\"http://www.springframework.org/schema/context\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.springframework.org/schema/beans\" xmlns:aop=\"http://www.springframework.org/schema/aop\" xmlns:mvc=\"http://www.springframework.org/schema/mvc\" xmlns:task=\"http://www.springframework.org/schema/task\" xmlns:util=\"http://www.springframework.org/schema/util\">	");

		/* for scannig the controller */
		fileWriter.write("<context:component-scan base-package=\"com.nisum."
				+ eventManager + ".controller\"></context:component-scan>");

		/* to find the view pages which return from the controller */
		fileWriter
				.write("<bean class=\"org.springframework.web.servlet.view.InternalResourceViewResolver\"> <property name=\"prefix\" value=\"/WEB-INF/jsp/\" /> <property name=\"suffix\" value=\".jsp\" /> </bean>");

		// mysql configuration
		fileWriter
				.write("<bean id=\"datasource\" class=\"org.springframework.jdbc.datasource.DriverManagerDataSource\">");
		fileWriter
				.write("<property name=\"driverClassName\" value=\"com.mysql.jdbc.Driver\" />");
		fileWriter
				.write("<property name=\"url\" value=\"jdbc:mysql://localhost:3306/project\" />");
		fileWriter.write("<property name=\"username\" value=\"root\" />");
		fileWriter.write("<property name=\"password\" value=\"1344\" />");
		fileWriter.write("</bean>");

		fileWriter
				.write("<bean id=\"jdbcTemplate\" class=\"org.springframework.jdbc.core.JdbcTemplate\">");
		fileWriter
				.write("<property name=\"dataSource\" ref=\"datasource\"></property>");
		fileWriter.write("</bean>");

		fileWriter.write("<bean id=\"dao\" class=\"com.nisum." + eventManager
				+ ".dao.Dao\">");
		fileWriter
				.write("<property name=\"jdbcTemplateObject\" ref=\"jdbcTemplate\" />");
		fileWriter.write("</bean>");

		fileWriter.write("</beans>");
		/*
		 * fileWriter .write(
		 * "<bean class=\"org.mybatis.spring.SqlSessionFactoryBean\" id=\"sqlSessionFactory\" lazy-init=\"true\">"
		 * + "<property name=\"dataSource\"ref=\"dataSource\"/>" +
		 * "<property name=\"configLocation\" value=\"WEB-INF/sqlmap-config.xml\" /> <!--  imolementation xml for the interface -->"
		 * + "</bean>");
		 * 
		 * fileWriter .write(
		 * "<bean class=\"org.mybatis.spring.SqlSessionTemplate\" id=\"sqlSessionTemplate\" lazy-init=\"true\">"
		 * + "<constructor-arg ref=\"sqlSessionFactory\" index=\"0\"/> " +
		 * "</bean> " +
		 * 
		 * "<bean id=\"student\" class=\"org.mybatis.spring.mapper.MapperFactoryBean\" lazy-init=\"true\">"
		 * +
		 * "<property name=\"sqlSessionTemplate\" ref=\"sqlSessionTemplate\" />"
		 * +
		 * "<property name=\"mapperInterface\" value=\"***************\" /> <!-- interface  -->"
		 * + "</bean>");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * to fing the .message files "<bean id=\"messageSource\"" +
		 * "class=\"org.springframework.context.support.ReloadableResourceBundleMessageSource\">"
		 * + "<property name=\"basename\" value=\"/WEB-INF/messages\" />" +
		 * "<property name=\"cacheSeconds\" value=\"3000\" />" + "</bean>");
		 * 
		 * fileWriter.write(
		 * "<bean id=\"mapper\" class=\"org.dozer.DozerBeanMapper\">" +
		 * "<property name=\"mappingFiles\">" + "<list>" +
		 * " <value>****************</value>" + " </list>" + " </property>" +
		 * "</bean>");
		 * 
		 * for the mail application configuration fileWriter .write(
		 * "<bean id=\"mailSender\" class=\"org.springframework.mail.javamail.JavaMailSenderImpl\">"
		 * +
		 * "<property name=\"host\" value=\"smtp.gmail.com\" /> <!-- since we are using gmail -->"
		 * +
		 * "<property name=\"port\" value=\"587\" /> <!-- since we are using gmail -->"
		 * + "<property name=\"username\" value=\"************\" />" +
		 * "<property name=\"password\" value=\"******************\" />" +
		 * " <property name=\"javaMailProperties\">" + " <props>" +
		 * "<prop key=\"mail.smtp.auth\">true</prop>" +
		 * "<prop key=\"mail.smtp.starttls.enable\">true</prop>" +
		 * " <prop key=\"mail.debug\">true</prop>" + " </props>" +
		 * " </property>" + "</bean>");
		 * 
		 * fileWriter.write("<bean id=\"****\" class=\"******\">" +
		 * "<property name=\"mailSender\" ref=\"mailSender\" />" + "</bean>" +
		 * "</beans>");
		 */

		fileWriter.close();

	}

	/*
	 * writing the data into main controller
	 */

	public void writingToMainController(String eventManager) throws IOException {

		fileWriter = new FileWriter(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/" + eventRootStructure[0] + "/"
						+ subWebInfStructure[0] + "/com/nisum/" + eventManager
						+ "/" + subClassesStructure[0] + "/" + classes[0]
						+ ".java");

		fileWriter
				.write("package com.nisum."
						+ eventManager
						+ ".controller;\n"
						+

						"import java.text.SimpleDateFormat;\n"
						+ "import java.util.ArrayList; \n"
						+ "import java.util.Date;\n"
						+ "import java.util.Iterator;\n"
						+ "import java.util.List;\n"
						+ "import java.util.Map;\n"
						+ "import java.util.Map.Entry;\n"
						+

						"import org.springframework.beans.factory.annotation.Autowired;\n"
						+ "import org.springframework.stereotype.Controller;  \n"
						+ "import org.springframework.web.bind.annotation.RequestMapping;\n"
						+ "import org.springframework.web.bind.annotation.RequestMethod;\n"
						+ "import org.springframework.web.bind.annotation.RequestParam;\n"
						+ "import org.springframework.web.servlet.ModelAndView;\n"
						+

						"import com.nisum."
						+ eventManager
						+ ".dao.Dao;\n"
						+

						"@Controller\n"
						+ "@RequestMapping(\"/controller\")\n"
						+ "public class MainController {\n"
						+

						"@Autowired\n"
						+ "Dao dao;\n"
						+

						"int count = 0;\n"
						+

						"@RequestMapping(\"/main\")\n"
						+ "public ModelAndView main() {\n"
						+

						"System.out.println(\"in main\");\n"
						+

						"return new ModelAndView(\"Success\");\n"
						+

						"} \n"
						+

						"@RequestMapping(value = \"/login\", method = RequestMethod.POST)\n"
						+ "public ModelAndView values(@RequestParam Map<String, String> allRequestParams) {\n"
						+

						"List<String> keys=new ArrayList<String>();\n"
						+ "List<String> values=new ArrayList<String>();\n"
						+

						"Iterator<Entry<String, String>> it = allRequestParams.entrySet().iterator();\n"
						+ "while (it.hasNext()) {\n"
						+ "  Entry<String, String> entry = it.next(); \n"
						+ "  if ((entry.getKey().contains(\"hidden\"))|| (entry.getKey().contains(\"data\"))|| (entry.getValue().equals(\"\"))) {\n"
						+ "     it.remove(); // avoids a ConcurrentModificationException \n"
						+ " }\n"
						+

						"} \n"
						+

						"for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {\n"
						+ "if (entry.getKey().contains(\"Label\")) {\n"
						+ "count++;\n"
						+ "}\n"
						+ "}\n"
						+

						"for (int j = 1; j <= count; j++) {\n"
						+

						"for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {\n"
						+

						"if (entry.getKey().equalsIgnoreCase(\"Label\" + j)) {\n"
						+

						"	System.out.println(keys.add(entry.getValue().replace(' ','_')));\n"
						+

						"}\n"
						+

						"if (entry.getKey().contains((\"\" + j + \"\"))\n"
						+ "&& (!(entry.getKey().equalsIgnoreCase(\"Label\" + j)))) {\n"
						+

						"if (entry.getKey().contains(\"Check\" + j))\n"
						+ "{\n"
						+ "String sample = null;\n"
						+ "for (int k = 0; k < allRequestParams.size(); k++) {\n"
						+ "for (Map.Entry<String, String> entry1 : allRequestParams\n"
						+ ".entrySet()) {\n"
						+ "if (entry1.getKey().contains(\"Check\" + j + k)) {\n"
						+

						"	sample += entry1.getValue();\n"
						+ "	}\n"
						+ "	}\n"
						+ "}\n"
						+"try\n"
						+ "{\n"
						+ "sample=sample.substring(4);\n"
						+ "}catch(Exception e)\n"
						+ "{\n"
						+ "e.printStackTrace();\n"
						+ "}\n"
						+ "if(!values.contains(sample))\n"
						+ "{\n"
						+ "	values.add(sample);\n"
						+ "}\n"
						+ "} else {\n"
						+ "if(!entry.getKey().contains(\"Check\"))\n"
						+ "{\n"
						+ "System.out.println(entry.getValue());\n"
						+ "values.add(entry.getValue());\n"
						+ "}\n"
						+ "}	\n"
						+

						"}\n"
						+

						"}\n"
						+

						"}\n"
						+

						"System.out.println(values);\n"
						+

						"System.out.println(\"values:\" + values);\n"
						+

						"Date date = new Date();\n"
						+ "System.out.println(\"date :\"+date);\n"
						+

						"SimpleDateFormat ddMMMyyFormat = new SimpleDateFormat(\"dd-MMM-yy\");\n"
						+ "String date_to_string = ddMMMyyFormat.format(date);\n"
						+ "System.out.println(\"Today's date into dd-MMM-yy format: \" + date_to_string);\n"
						+

						"dao.saveDetails(keys,values,date_to_string);\n" +

						"return new ModelAndView(\"End\");\n" +

						"}\n" + "}\n");

		fileWriter.close();

	}

	/* writing the data into dao */
	public void writingToDao(String eventManager) throws IOException {

		fileWriter = new FileWriter(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/" + eventRootStructure[0] + "/"
						+ subWebInfStructure[0] + "/com/nisum/" + eventManager
						+ "/" + subClassesStructure[7] + "/" + classes[7]
						+ ".java");

		fileWriter
				.write("package com.nisum."
						+ eventManager
						+ ".dao;"
						+

						"import java.sql.ResultSet; \n"
						+ //
						"import java.sql.SQLException;\n"
						+ //
						"import java.util.List;\n"
						+ //

						"import org.springframework.jdbc.core.JdbcTemplate;\n"
						+ "import org.springframework.jdbc.core.RowMapper;\n"
						+

						"import com.nisum."
						+ eventManager
						+ ".model.Model;\n"
						+

						"public class Dao {\n"
						+

						"private JdbcTemplate  jdbcTemplateObject;\n"
						+

						"public final void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {\n"
						+ "	this.jdbcTemplateObject = jdbcTemplateObject;\n"
						+ "}\n"
						+

						"public void saveDetails( List<String> keys, List<String> values, String date_to_string) { \n"
						+ "int i = 2; \n"
						+

						"String sql1 = \"SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = \'project\' AND TABLE_NAME =?\";\n"
						+

						"	List<Model> columnList = jdbcTemplateObject.query(sql1,\n"
						+ "			new Object[] { \""
						+ eventManager
						+ "\" }, new EventRowMapper());\n"
						+

						"	String sql2 = \"select count(id)  from "
						+ eventManager
						+ " \";\n"
						+

						"	int a = jdbcTemplateObject.queryForInt(sql2); \n"
						+

						"a = a + 1; \n"
						+

						"				sql2 = \"insert into "
						+ eventManager
						+ " (\" + columnList.get(0).getEventName() +\",\"  \n"
						+ "						+ columnList.get(1).getEventName() + \") values(\'\" + a + \"\',\'\"   \n"
						+ "						+ date_to_string + \"\')\";  \n"
						+ "			jdbcTemplateObject.update(sql2);\n"
						+

						"			for (int j=0;j<keys.size();j++) {\n"
						+

						"		String sql4 = \"UPDATE "
						+ eventManager
						+ " SET \" +keys.get(j)\n"
						+ "					+ \"=\'\" + values.get(j) + \"\' where id=\'\"+a+\"\'\";\n"
						+ "			jdbcTemplateObject.update(sql4);\n" +

						"}\n" + "	System.out.println(\"success\");\n" +

						"}\n" +

						"public class EventRowMapper implements RowMapper<Model>{\n"
						+

						"public Model mapRow(ResultSet rs, int rowNum) throws SQLException {\n"
						+ "Model eventnameModel= new Model();\n"
						+ "eventnameModel.setEventName(rs.getString(1));\n"
						+ "return eventnameModel;\n" + "}\n" + "}\n" +

						"}\n");

		fileWriter.close();

	}

	/* writing the data into model */
	public void writingToModel(String eventManager) throws IOException {

		fileWriter = new FileWriter(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/" + eventRootStructure[0] + "/"
						+ subWebInfStructure[0] + "/com/nisum/" + eventManager
						+ "/" + subClassesStructure[6] + "/" + classes[6]
						+ ".java");

		fileWriter.write("package com.nisum." + eventManager + ".model;" +

		"public class Model {" +

		"String eventName;" +

		"public String getEventName() {" + "return eventName;" + "}" +

		"public void setEventName(String eventName) {"
				+ "this.eventName = eventName;" + "}" +

				"}");

		fileWriter.close();
	}
}