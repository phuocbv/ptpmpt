package project.DO;
// Generated Sep 25, 2016 1:03:51 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * File generated by hbm2java
 */
@Entity
@Table(name="document"
    ,catalog="mydb"
)
public class Document  implements java.io.Serializable {


     private Integer idfile;
     private String src;
     private String size;
     private String titleFile;
     private String type;
     private String createDate;
     private int idIndex;
     private String column1;
     private String column2;
     private String column3;

    public Document() {
    }

	
    public Document(String src, String size, String titleFile, String type, String createDate, int idIndex) {
        this.src = src;
        this.size = size;
        this.titleFile = titleFile;
        this.type = type;
        this.createDate = createDate;
        this.idIndex = idIndex;
    }
    public Document(String src, String size, String titleFile, String type, String createDate, int idIndex, String column1, String column2, String column3) {
       this.src = src;
       this.size = size;
       this.titleFile = titleFile;
       this.type = type;
       this.createDate = createDate;
       this.idIndex = idIndex;
       this.column1 = column1;
       this.column2 = column2;
       this.column3 = column3;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idfile", unique=true, nullable=false)
    public Integer getIdfile() {
        return this.idfile;
    }
    
    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    
    @Column(name="src", nullable=false, length=100)
    public String getSrc() {
        return this.src;
    }
    
    public void setSrc(String src) {
        this.src = src;
    }

    
    @Column(name="size", nullable=false, length=45)
    public String getSize() {
        return this.size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }

    
    @Column(name="title_file", nullable=false, length=45)
    public String getTitleFile() {
        return this.titleFile;
    }
    
    public void setTitleFile(String titleFile) {
        this.titleFile = titleFile;
    }

    
    @Column(name="type", nullable=false, length=45)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
    @Column(name="create_date", nullable=false, length=45)
    public String getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="id_index", nullable=false)
    public int getIdIndex() {
        return this.idIndex;
    }
    
    public void setIdIndex(int idIndex) {
        this.idIndex = idIndex;
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

