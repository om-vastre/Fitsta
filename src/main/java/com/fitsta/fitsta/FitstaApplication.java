package com.fitsta.fitsta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fitsta.fitsta.Entity.Plans;
import com.fitsta.fitsta.Entity.PlansPurchase;
import com.fitsta.fitsta.Entity.Task;
import com.fitsta.fitsta.Entity.Trainer;
import com.fitsta.fitsta.Entity.User;
import com.fitsta.fitsta.Repository.ProductRepository;
import com.fitsta.fitsta.Repository.TrainerRepository;

@SpringBootApplication
public class FitstaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FitstaApplication.class, args);
		// ProductRepository productRepository = context.getBean(ProductRepository.class);
		TrainerRepository trainerRepository = context.getBean(TrainerRepository.class);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		try {

			Trainer t1 = new Trainer();
			t1.setId(0);
			t1.setName("Harsh");
			t1.setDob(new java.sql.Date(dateFormat.parse("11/10/93").getTime()));
			t1.setGender("Male");
			t1.setContactno("1234567890");
			t1.setImage("/img/t1.png");
			t1.setSpecialization("Weight Loss");
			t1.setExperience("5 Yrs");
			t1.setUsername("harsh@gmail.com");
			t1.setPassword("Pass@123");

			PlansPurchase pp1 = new PlansPurchase();
			pp1.setId(0);
			pp1.setPurchasedate(new java.sql.Date(dateFormat.parse("26/08/23").getTime()));
			pp1.setExpirydate(new java.sql.Date(dateFormat.parse("26/09/23").getTime()));
			PlansPurchase pp2 = new PlansPurchase();
			pp2.setId(0);
			pp2.setPurchasedate(new java.sql.Date(dateFormat.parse("25/08/23").getTime()));
			pp2.setExpirydate(new java.sql.Date(dateFormat.parse("25/09/23").getTime()));

			List<User> users = new ArrayList<>();
			User u1 = new User(0, "Om", new java.sql.Date(dateFormat.parse("04/11/03").getTime()), "Male", "7410852963", "Begampur", 50, 164, "om04@gmail.com", "Pass@123", t1, pp1);
			users.add(u1);
			User u2 = new User(0, "Imran", new java.sql.Date(dateFormat.parse("10/10/03").getTime()), "Male", "8529637410", "Bramhapuri", 60, 162, "imran@gmail.com", "Pass@123", t1, pp2);
			users.add(u2);
			
			pp1.setEnrolleduser(u1);
			pp2.setEnrolleduser(u2);

			t1.setUsers(users);


			List<Plans> plans = new ArrayList<>();
			Plans p1 = new Plans(0, "Gravy Losser", "Weight Loss", "Money Back Gaureenty\nPremium Service\nDaily Diet Controll Remainder", 2599, 1, t1);
			plans.add(p1);
			t1.setPlans(plans);

			pp1.setEnrolledplan(p1);
			pp2.setEnrolledplan(p1);

			Task tsk1 = new Task(0, new java.sql.Date(dateFormat.parse("25/09/23").getTime()), "Cardio", "80g Paneer", "2", "1500", true, t1);
			Task tsk2 = new Task(0, new java.sql.Date(dateFormat.parse("26/09/23").getTime()), "Leg", "80g Paneer", "2", "1000", false, t1);
			List<Task> tasks = new ArrayList<>();
			tasks.add(tsk1);
			tasks.add(tsk2);
			t1.setTasks(tasks);

			Trainer savedTrainer = trainerRepository.save(t1);


			System.out.println("Trainer -> Each user :");
			List<User> trainerUsers = savedTrainer.getUsers();
			for (User eachUser : trainerUsers) {
				System.out.println("\t Name : "+eachUser.getName());
				System.out.println("\t Users Trainer : "+eachUser.getTrainer().getName());
				System.out.println("\t Users -> Purchsed Plan -> Name : "+eachUser.getUserPlansPurchase().getEnrolledplan().getName());
				System.out.println("\t Users -> Purchsed Plan -> Purchased Date : "+eachUser.getUserPlansPurchase().getPurchasedate());
				System.out.println("\t Users -> Purchsed Plan -> Expiry Date : "+eachUser.getUserPlansPurchase().getExpirydate());
			}

			System.out.println("\nTrainers -> Plans : ");
			List<Plans> trainerPlans = savedTrainer.getPlans();
			for (Plans eachPlan : trainerPlans) {
				System.out.println("\t Plan Name : "+eachPlan.getName());
				System.out.println("\t Trainer of Plan : "+eachPlan.getPlanstrainer().getName());
			}

			System.out.println("\nTrainer -> Tasks :");
			for (Task eachTask : savedTrainer.getTasks()) {
				System.out.println("\t Task Date : "+ eachTask.getWorkoutDate());
				System.out.println("\t Task Workout : "+ eachTask.getWorkout());
				System.out.println("\t Task Status : "+ eachTask.getIscompleted());
			}


		} catch (ParseException e) {e.printStackTrace();}


	}

}