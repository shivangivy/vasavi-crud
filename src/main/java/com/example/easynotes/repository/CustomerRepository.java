/**
 * 
 */
package com.example.easynotes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.easynotes.model.Customer;

/**
 * @author Electem2
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
//	@Query("select * from student s where s.branch = 'cse'");
//	List<Student> fetchStudetns()
}
