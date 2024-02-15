# jdbc-crud-operation
with the help of jdbc we connected our java apllication code to database(sql)
domainName.companyName.projectName.module[dto]-------------Student.java             [encapsulation class]
domainName.companyName.projectName.module[connection]------StudentConnection.java   [this is connection class]
domainName.companyName.projectName.module[service]---------StudentService.java      [at here we gives the logic according to client]
domainName.companyName.projectName.module[Dao]-------------StudentDao.java          [inside this class we write the SQL query]
domainName.companyName.projectName.module[controller]------StdentController        [from this we class we control all this like  insert,update,delete]
