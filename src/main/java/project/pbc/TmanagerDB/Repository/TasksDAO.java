package project.pbc.TmanagerDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.pbc.TmanagerDB.Entity.Tasks;

@Repository
public interface TasksDAO extends JpaRepository<Tasks, Long> {

}
