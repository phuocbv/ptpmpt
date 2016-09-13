package project.DO;
// Generated Sep 11, 2016 4:47:28 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AccountInfo generated by hbm2java
 */
@Entity
@Table(name="account_info"
    ,catalog="mydb"
)
public class AccountInfo  implements java.io.Serializable {


     private Integer id;
     private String firstName;
     private String lastName;
     private String school;
     private String class_;
     private String address;
     private String accountInfocol;
     private Integer idAccount;

    public AccountInfo() {
    }

	
    public AccountInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public AccountInfo(String firstName, String lastName, String school, String class_, String address, String accountInfocol, Integer idAccount) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.school = school;
       this.class_ = class_;
       this.address = address;
       this.accountInfocol = accountInfocol;
       this.idAccount = idAccount;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="first_name", nullable=false, length=100)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", nullable=false, length=100)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="school", length=100)
    public String getSchool() {
        return this.school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }

    
    @Column(name="class", length=100)
    public String getClass_() {
        return this.class_;
    }
    
    public void setClass_(String class_) {
        this.class_ = class_;
    }

    
    @Column(name="address", length=200)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="account_infocol", length=45)
    public String getAccountInfocol() {
        return this.accountInfocol;
    }
    
    public void setAccountInfocol(String accountInfocol) {
        this.accountInfocol = accountInfocol;
    }

    
    @Column(name="id_account")
    public Integer getIdAccount() {
        return this.idAccount;
    }
    
    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }




}


