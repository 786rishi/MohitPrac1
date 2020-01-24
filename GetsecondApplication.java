package getemploye.getsecond;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class GetsecondApplication {

	List<Emp> list = new ArrayList<>();
	List<Area> arealist =new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(GetsecondApplication.class, args);
	}



@GetMapping ("/getEmp")
public List<Emp> getEmp(){
	return list;
		}

@PostMapping ("addEmp")
public String add (@RequestBody Emp emp){
	list.add(emp);
	return "Employee added successfull";
	
}

@PutMapping ("UpdateEmp/{id}")
public String update (@RequestBody Emp updateEmp, @PathVariable int id)

{
	list.forEach(empolyee-> {
		if (updateEmp.getId() == id)
	{
				empolyee.setFirstname(updateEmp.getFirstname());
				empolyee.setLastname(updateEmp.getLastname());
				Area.setArea(Area.getArea());
				empolyee.setPincode(updateEmp.getPincode());
				
				
				
	}
	});
	return "Emp update";
	
}

@DeleteMapping ("/deletemp/{id}")
public String delete (@PathVariable int id ){
	list.removeIf(Emp -> Emp.getId() == id);
	return "remove";
}


}
