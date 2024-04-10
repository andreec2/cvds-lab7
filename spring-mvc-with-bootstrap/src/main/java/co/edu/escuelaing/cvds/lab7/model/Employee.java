package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Entity
@Table(name = "CONFIGURATION")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employee_id;
    @Column(name = "FIRST_NAME")
    private String first_name;
    @Column(name = "LAST_NAME")
    private String last_name;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "SALARY")
    private Double salary;

    public Employee() {
    }

    public Employee(String employee_id, String first_name, String role, String last_name, Double salary) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.salary = salary;
        this.role = role;
        this.last_name  = last_name;
    }

    public String getemployee_id() {
        return employee_id;
    }

    public void setemployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }


    // Método para obtener el nombre de un empleado por su ID
    public static String obtenerNombrePorID(String employee_id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nombre_de_tu_unidad_de_persistencia");
        EntityManager em = emf.createEntityManager();
        String nombre = null;

        try {
            em.getTransaction().begin();

            // Consulta para obtener el nombre del empleado por su ID
            Query query = em.createQuery("SELECT e.first_name FROM Employee e WHERE e.employee_id = :employeeId");
            query.setParameter("employeeId", employee_id);

            // Ejecutar la consulta y obtener el nombre
            nombre = (String) query.getSingleResult();

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

        return nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employee_id == null) ? 0 : employee_id.hashCode());
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Configuration [propiedad = " + employee_id + ", valor = " + first_name + "]";
    }
}