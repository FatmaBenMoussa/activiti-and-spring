import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TransactionalBean {
	@Autowired
	private RuntimeService runtimeService;
	@Transactional
	public void execute()
	throws Exception {
	runtimeService.startProcessInstanceByKey(
	"myProcess");}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
TransactionalBean t=new TransactionalBean();
t.execute();
	}

}
