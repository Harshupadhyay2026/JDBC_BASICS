package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            unique = true,
            nullable = false,
            length = 150,
            insertable = true,
            updatable = true
    )
    private String email;

    private int age;



//    @ElementCollection
//    @CollectionTable(
//            name = "Student skills",
//            joinColumns = @JoinColumn(name = "student_id")
//    )
//   private List<Student> skills;

    @ElementCollection
   @CollectionTable(
           name = "Student_adresses",
            joinColumns = @JoinColumn(name = "student_id"))
    private List<Adress> adresses ;


//
//    @Embedded
//    @AttributeOverrides(
//            {
//                    @AttributeOverride(
//                            name = "houseNo",
//                            column = @Column(name ="current house no")
//                    ),
//
//                    @AttributeOverride(
//                            name = "street",
//                            column = @Column(name ="current street")
//                    ),
//
//                    @AttributeOverride(
//                            name = "city",
//                            column = @Column(name ="current city")
//                    ),
//
//                    @AttributeOverride(
//                            name = "state",
//                            column = @Column(name ="current state")
//                    ),
//                    @AttributeOverride(
//                            name = "pincode",
//                            column = @Column(name ="current pincode")
//                    ),
//            }
//    )
//      private Adress currentadress;
//
//    @Embedded
//    @AttributeOverrides(
//            {
//                    @AttributeOverride(
//                            name = "houseNo",
//                            column = @Column(name ="parmanent house no")
//                    ),
//
//                    @AttributeOverride(
//                            name = "street",
//                            column = @Column(name ="parmanent street")
//                    ),
//
//                    @AttributeOverride(
//                            name = "city",
//                            column = @Column(name ="parmanent city")
//                    ),
//
//                    @AttributeOverride(
//                            name = "state",
//                            column = @Column(name ="parmanent state")
//                    ),
//                    @AttributeOverride(
//                            name = "pincode",
//                            column = @Column(name ="parmanent pincode")
//                    ),
//            }
//    )
//    private Adress parmanentadress;




//    @Column(precision = 5, scale = 2)
//    private BigDecimal percentage;
//
//    private LocalDate dateofbirth;
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus studentStatus;
//
//    @Lob
//    private String profileDescription;
//
//    @Transient
//    private String displayName;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private Boolean isMonitor;
//
//    private LocalDateTime createdat;


    public Student() {
    }

    public Student(Long id, String name, String email, int age, List<Adress> adresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.adresses = adresses;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }
}
//        this.percentage = percentage;
//        this.dateofbirth = dateofbirth;
//        this.studentStatus = studentStatus;
//        this.profileDescription = profileDescription;
//        this.displayName = displayName;
//        this.isMonitor = isMonitor;
//        this.createdat = createdat;

//
//    public BigDecimal getPercentage() {
//        return percentage;
//    }
//
//    public void setPercentage(BigDecimal percentage) {
//        this.percentage = percentage;
//    }
//
//    public LocalDate getDateofbirth() {
//        return dateofbirth;
//    }
//
//    public void setDateofbirth(LocalDate dateofbirth) {
//        this.dateofbirth = dateofbirth;
//    }
//
//    public StudentStatus getStudentStatus() {
//        return studentStatus;
//    }
//
//    public void setStudentStatus(StudentStatus studentStatus) {
//        this.studentStatus = studentStatus;
//    }
//
//    public String getProfileDescription() {
//        return profileDescription;
//    }
//
//    public void setProfileDescription(String profileDescription) {
//        this.profileDescription = profileDescription;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public Boolean getMonitor() {
//        return isMonitor;
//    }
//
//    public void setMonitor(Boolean monitor) {
//        isMonitor = monitor;
//    }
//
//    public LocalDateTime getCreatedat() {
//        return createdat;
//    }
//
//    public void setCreatedat(LocalDateTime createdat) {
//        this.createdat = createdat;
//    }
