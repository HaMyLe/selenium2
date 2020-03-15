## JAVA CORE

### Packages

A package should be named in lowercase characters. There should be only one English word after each dot.  

`` ` ``java
import com.directasia.dataObjects;
import com.directasia.utils.helpers;
import com.logigear.control.common.imp;
`` ` ``

### Classes

Class names should be nouns in UpperCamelCase (in mixed case with the first letter of each internal word capitalized). Try to keep your class names simple and descriptive.
`` ` ``java
class Employee {}
class Student {}
class EmployeeDao {}
class CompanyService {}
`` ` ``

### Interfaces

In Java, interfaces names, generally, should be adjectives. Interfaces should be in titlecase with the first letter of each separate word capitalized. In some cases, interfaces can be nouns as well when they present a family of classes e.g. List and Map.
`` ` ``java
interface Runnable {}
interface Remote {}
interface ActionListener {}
interface Appendable {}
`` ` ``

### Methods

Methods always should be verbs. They represent action and the method name should clearly state the action they perform. The method name can be single or 2-3 words as needed to clearly represent the action. Words should be in camel case notation.
`` ` ``java
interface Customer {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

}
`` ` ``

### Variables

The variable name should start with a lowercase letter. Parameter names, member variable names, and local variable names should be written in lowerCamelCase.
Should not start with underscore(â€˜_â€™) or dollar sign â€˜$â€™ characters.
Should be mnemonic i.e, designed to indicate to the casual observer the intent of its use.
One-character variable names should be avoided except for temporary variables.
`` ` ``
firstName
orderNumber
lastName
phoneNo
id
`` ` ``

### Constants

Constant variable names should be written in upper characters separated by underscores. These names should be semantically complete and clear.
Example:
`` ` ``
RED, YELLOW, MAX*PRIORITY, MAX*STOCK_COUNT
`` ` ``

### Abstract

I observed in many standard libraries, the naming conventions used for Abstract class is class name must start with Abstract or Base prefix. This naming convention can vary from organization to organization. 
`` ` ``
AbstractHibernateDao
AbstractCommonDao
AbstractBase
`` ` ``

### Enumeration

Enum Class members should be spelled out in upper case words, separated by underlines. Example:
`` ` ``java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}
`` ` ``

### Generic types

Generic type parameter names should be uppercase single letters. The letter 'T' for a type is typically recommended. In JDK classes, E is used for collection elements, S is used for service loaders, and K and V are used for map keys and values.
`` ` ``java
class Utilities {
    public interface Map <K,V> {}

    public interface List<E> extends Collection<E> {}

    Iterator<E> iterator() {}

}
`` ` ``

### Class template

Class implementation should be well-organized. The following is suggestion structure:

* Scripts/sources are grouped into intentional section
* Some of common sections in order: Element Definition, Constructor/Destructor/Init, Private Methods, Public Methods
* Section annotation: Keyword region
  `` ` ``java
  class AbstractPage {
        //region Header
        private String lnkHome = "//a[text()='Home']";
        private String btnLogin = ".btn-login";
        //endregion
    //region Footer
    private String btnContactUs = "#contactUs";
    private String lnkClaim = ".claim";
    //endregion

}
`` ` ``

## SELENIUM

### Web Element locator variable names

| Prefix   |Control Type    | Example                |
| -------- |:---------------|-----------------------:|
| btn      | Button         | btnGetTravel           |
| txt      | Textbox        | txtCityName            |
| rdb      | Radio Button   | rdbVehicleType         |
| cbb      | Combobox       | btnGetTravel           |
| daRdb    | DARadioButton  | daRadioVehicleType     |
| daCbx    | DACheckbox     | daCbxTravelAlone       |
| lnk      | Link           | lnkCity                |
| lbl      | Label          | lblErrorMessage        |
| iditCbb  | IDITCombobox   | iditCbbEnglish         |

