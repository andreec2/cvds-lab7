import React, { useState, useEffect } from "react";
import { createEmployee, getEmployee, updateEmployee } from "../services/EmployeeService";
import { useNavigate, useParams } from "react-router-dom";

const  EmployeeComponent = () => {

    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [role, setRole] = useState('')
    const [salary, setSalary] = useState('')

    const[errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        role: '',
        salary: ''
    })

    const {id} = useParams();
    const navegator = useNavigate();

    useEffect(() => {
        if(id){
            getEmployee(id).then((response) => {
                setFirstName(response.data.firstName);
                setLastName(response.data.lastName);
                setRole(response.data.role);
                setSalary(response.data.salary);
            }).catch(error => {
                console.error(error);
            })
        }
    }

    )

    function saveOrUpdateEmployee(e){
        e.preventDefault();

        if(validateForm()){

            const employee = {firstName, lastName, role, salary}
            console.log(employee)

            if(id){
                updateEmployee(id, employee).then((response) => {
                    console.log(response.data);
                    navegator('/employees')
                }).catch(error => {
                    console.error(error);
                })
            } else{
                createEmployee(employee).then((response) => {
                    console.log(response.data);
                    navegator('/employees')
                }).catch(error => {
                    console.error(error);
                })
            }
        }
    }

    function validateForm(){
        let valid = true;

        const errorsCopy = {...errors}

        if(firstName.trim()){
            errorsCopy.firstName = '';
        } else {
            errorsCopy.firstName = 'First name is requires';
            valid = false;
        }

        if(lastName.trim()){
            errorsCopy.lastName = '';
        } else {
            errorsCopy.lastName = 'Last name is requires';
            valid = false;
        }

        if(role.trim()){
            errorsCopy.role = '';
        } else {
            errorsCopy.role = 'Role is requires';
            valid = false;
        }

        if(String(salary).trim()){
            errorsCopy.salary = '';
        } else {
            errorsCopy.salary = 'Salary is requires';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function pageTitle(){
        if(id){
            return <h2 className="text-center"> Update Employee</h2>
        }else{
            return <h2 className="text-center"> Add Employee</h2>
        }
    }

    return (
        <div className="container">
            <div className="card">
                {
                    pageTitle()
                }
                <div className="card-body">
                    <form>
                        <div className="form-group mb-2">
                            <label className="from-label">First Name</label>
                            <input
                                type="text"
                                placeholder="Enter Employee First Name"
                                name="firstName"
                                value={firstName}
                                className={`form-control ${ errors.firstName ? 'is-invalid': ''}`}
                                onChange={(e) => setFirstName(e.target.value)}
                            >
                            </input>
                            { errors.firstName && <div className="invalid-feedback"> { errors.firstName} </div>}
                        </div>
                        <div className="form-group mb-2">
                            <label className="from-label">Last Name</label>
                            <input
                                type="text"
                                placeholder="Enter Employee Last Name"
                                name="lastName"
                                value={lastName}
                                className={`form-control ${ errors.lastName ? 'is-invalid': ''}`}
                                onChange={(e) => setLastName(e.target.value)}
                            >
                            </input>
                            { errors.lastName && <div className="invalid-feedback"> { errors.lastName} </div>}
                        </div>
                        <div className="form-group mb-2">
                            <label className="from-label">Role</label>
                            <input
                                type="text"
                                placeholder="Enter Employee Role"
                                name="role"
                                value={role}
                                className={`form-control ${ errors.role ? 'is-invalid': ''}`}
                                onChange={(e) => setRole(e.target.value)}
                            >
                            </input>
                            { errors.role && <div className="invalid-feedback"> { errors.role} </div>}
                        </div>
                        <div className="form-group mb-2">
                            <label className="from-label">Salary</label>
                            <input
                                type="number"
                                placeholder="Enter Employee Salary"
                                name="salary"
                                value={salary}
                                className={`form-control ${ errors.salary ? 'is-invalid': ''}`}
                                onChange={(e) => setSalary(e.target.value)}
                            >
                            </input>
                            { errors.salary && <div className="invalid-feedback"> { errors.salary} </div>}
                        </div>

                        <button className="btn btn-succes" onClick={saveOrUpdateEmployee}>Submit</button>
                    </form> 

                </div>
            </div>

        </div>
    )
}

export default EmployeeComponent