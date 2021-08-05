CREATE TABLE Employee (
    employee_id int PRIMARY KEY AUTO_INCREMENT,
    f_name varchar(50) NOT NULL,
    l_name varchar(50) NOT NULL,
    ni_number varchar(13) NOT NULL,
    employee_address varchar(100) NOT NULL,
    salary decimal(11,2) NOT NULL,
    bank_detail varchar(100) NOT NULL,
    is_manager boolean NOT NULL DEFAULT 0,
    active boolean NOT NULL DEFAULT false,
    employee_type enum('HR', 'Sales', 'Finance', 'BU', 'Technical') not null
)

CREATE TABLE EmployeeInfo (
    photo varchar(100),
    cv varchar(100),         -- file or path ????
    employee_id int FOREIGN KEY REFERENCES Employee(employee_id)
)

CREATE TABLE SalesEmployee (
    sales_id int PRIMARY KEY AUTO_INCREMENT,
    commission_rate decimal(5,2) NOT NULL CHECK(commission_rate <= 100),
    sales_total mediumint NOT NULL default 0,
    employee_id int FOREIGN KEY REFERENCES Employee(employee_id)
)

CREATE TABLE Project (
    project_id int PRIMARY KEY AUTO_INCREMENT,
    active boolean DEFAULT false,
    project_name varchar(100) NOT NULL,

)

CREATE TABLE ProjectAssignments (
    assignement_id int PRIMARY KEY AUTO_INCREMENT,
    employee_id int FOREIGN KEY REFERENCES Employee(employee_id),
    project_id int FOREIGN KEY REFERENCES Project(project_id)
    starting_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ending_date datetime DEFAULT NULL CHECK(ending_date > starting_date) 
)
