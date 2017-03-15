

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration("activiti.cfg.xml")
public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"activiti.cfg.xml");
		RepositoryService repositoryService =
				  (RepositoryService) applicationContext.getBean("repositoryService");
		String deploymentId = repositoryService
				  .createDeployment()
				  .addClasspathResource("yz.bpmn")
				  .deploy()
				  .getId();	 
		ProcessEngine processEngine= (ProcessEngine) applicationContext.getBean("processEngine");
		  System.out.println(deploymentId);
		  RuntimeService runtimeService = processEngine.getRuntimeService();
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
	/*	//starting it 
	 	Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employeeName", "Kermit");
		variables.put("numberOfDays", new Integer(4));
		variables.put("vacationMotivation", "I'm really tired!");
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
 
	
		// Fetch all tasks for the management group
		TaskService taskService = processEngine.getTaskService();
		java.util.List<org.activiti.engine.task.Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		for (org.activiti.engine.task.Task task : tasks) {
		 System.out.println("Task available: " + task.getName());
		} 
		*/
	} 

}
