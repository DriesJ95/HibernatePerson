package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "PERSONS", indexes = {@Index(name = "LAST_NAME_INDEX", columnList = "LAST_NAME"),
        @Index(name = "BIRTHDAY_INDEX",columnList = "BIRTHDAY")})
@SecondaryTable(name="URLS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Version
    @Column(name = "VERSION")
    private long version;
    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private String lastName;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name = "GENDER", updatable = false, length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Column(name = "PICTURE")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] picture;
    @Column(name = "COMMNT")
    private String comment;
    @Column(name = "MARRIED")
    private boolean married;
    @Transient
    private int age;
    @Column(name = "HOMEPAGE", table = "URLS")
    private String homepage;
    @Embedded
    private Address address;

    public Person(String firstName, String lastName, LocalDate birthday, GenderType gender,
                  byte[] picture, String comment, boolean married, String homepage) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homepage = homepage;
    }

    public Person(){}

    public Address getAddress() {
        return address;
    }

    public Person setAddress(Address address) {
        this.address = address;
        return this;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public Person setVersion(long version) {
        this.version = version;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Person setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public GenderType getGender() {
        return gender;
    }

    public Person setGender(GenderType gender) {
        this.gender = gender;
        return this;
    }

    public byte[] getPicture() {
        return picture;
    }

    public Person setPicture(byte[] picture) {
        this.picture = picture;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Person setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isMarried() {
        return married;
    }

    public Person setMarried(boolean married) {
        this.married = married;
        return this;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthday,LocalDate.now());
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public Person setHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", age=" + getAge() +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
