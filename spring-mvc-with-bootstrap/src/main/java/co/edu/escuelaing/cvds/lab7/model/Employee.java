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
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
     */

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "SALARY")
    private Double salary;

    public Employee() {
    }

    public Employee(String employee_id, String first_name, String role, String last_name, Double salary) {
        this.employeeId = employee_id;
        this.firstName = first_name;
        this.salary = salary;
        this.role = role;
        this.lastName  = last_name;
    }

    public String getemployee_id() {
        return employeeId;
    }

    public void setemployee_id(String employee_id) {
        this.employeeId = employee_id;
    }

    public String getfirst_name() {
        return firstName;
    }

    public void setfirst_name(String first_name) {
        this.firstName = first_name;
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
        result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Configuration [propiedad = " + employeeId + ", valor = " + firstName + "]";
    }
}