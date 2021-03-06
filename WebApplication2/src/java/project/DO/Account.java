package project.DO;
// Generated Sep 25, 2016 1:03:51 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name="account"
    ,catalog="mydb"
)
public class Account  implements java.io.Serializable {


     private Integer idaccount;
     private String username;
     private String password;
     private String accountName;
     private String createDate;
     private String column1;
     private String column2;
     private String column3;

    public Account() {
    }

	
    public Account(String username, String password, String accountName, String createDate) {
        this.username = username;
        this.password = password;
        this.accountName = accountName;
        this.createDate = createDate;
    }
    public Account(String username, String password, String accountName, String createDate, String column1, String column2, String column3) {
       this.username = username;
       this.password = password;
       this.accountName = accountName;
       this.createDate = createDate;
       this.column1 = column1;
       this.column2 = column2;
       this.column3 = column3;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idaccount", unique=true, nullable=false)
    public Integer getIdaccount() {
        return this.idaccount;
    }
    
    public void setIdaccount(Integer idaccount) {
        this.idaccount = idaccount;
    }

    
    @Column(name="username", nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="account_name", nullable=false, length=45)
    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    
    @Column(name="create_date", nullable=false, length=45)
    public String getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="column1", length=45)
    public String getColumn1() {
        return this.column1;
    }
    
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    
    @Column(name="column2", length=45)
    public String getColumn2() {
        return this.column2;
    }
    
    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    
    @Column(name="column3", length=45)
    public String getColumn3() {
        return this.column3;
    }
    
    public void setColumn3(String column3) {
        this.column3 = column3;
    }




}


