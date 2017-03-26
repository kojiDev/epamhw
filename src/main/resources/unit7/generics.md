```
class MedicalStaff{}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}
```

| | | |
|---|---|---|
| `Doctor doctor1 = new Doctor();` | Correct | Obvious |
| `Doctor doctor2 = new MedicalStaff();` | Correct | MedicalStaff is a Doctor |
| `Doctor doctor3 = new HeadDoctor();` | Correct | HeadDoctor is a Doctor |
| `Object object1 = new HeadDoctor();` | Correct | HeadDoctor is an Object |
| `HeadDoctor doctor5 = new Object();` | Incorrect | Object is not a Head Doctor |
| `Doctor doctor6 = new Nurse();` | Correct | Nurse is a Doctor |
| `Nurse nurse = new Doctor();` | Incorrect | Doctor is not a Nurse |
| `Object object2 = new Nurse();` | Correct | Nurse is an Object |
| `List<Doctor> list1= new ArrayList<Doctor>();` | Correct | ArrayList of Doctors is a List of Doctors |
| `List<MedicalStaff> list2 = new ArrayList<Doctor>();` | Incorrect | You got the idea |

