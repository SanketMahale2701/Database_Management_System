/* 
    Refer Link :- https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

    
   insert into table student values ___ ___ ___ ( 1. name, 2. Age, 3. Marks)
   select * from student
   select * from student where rollno = 11
   select * from student where name = Sagar
   delete from student where rollno = 3
   select max marks from student
   select max  age  from student
   select min marks from student 
   select min  age  from student
   select sum marks from student
   select sum  age  from student
   select avg marks from student 
   select avg  age  from student  
   select count from student where name = Sagar
   select count of record from student
*/

/////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

public class Dbms
{ 
    public static void main(String Agrs[])
    {
        System.out.println("+----------------------------------------------------------------------------+");
        DBMS obj = new DBMS(); 
        obj.StartDBMS();
    }
}

/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<Student>();
    }

   //--------------------------------------------------------------
   
    public void StartDBMS()
    {
        // Welcome Mathod
        System.out.println();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| DBMS Started Successfully...                           |");
        System.out.println("| Table schema created successfully...                   |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println();
        
        String Query;
        String Tokens[];

        Scanner sobj = new Scanner(System.in);
        int TokensCount = 0;
        
        while(true)
        {
            System.out.print("My DBMS -: ");
            Query = sobj.nextLine();

            Tokens = Query.split(" ");

            TokensCount = Tokens.length;

            if(TokensCount == 1)
            {
                if("exit".equals(Tokens[0]))
                {
                    System.out.println("\nThank you for using DBMS...\n");
                    System.out.println("+----------------------------------------------------------------------------+");
                    break;
                }
                else
                {
                    System.out.println("\nPlease enter the valid command. \n");
                }
            }
            else if(TokensCount == 2)
            {}
            else if(TokensCount == 3)
            {}
            else if(TokensCount == 4)
            {
                if("select".equals(Tokens[0]))
                {
                     SelectFrom();
                }
                else
                {
                    System.out.println("\nPlease enter the valid command. \n");
                }
            }      
            else if(TokensCount == 5)
            {
                if("select".equals(Tokens[0]))
                {  
                    if("max".equals(Tokens[1]))
                    {
                        if("marks".equals(Tokens[2]))
                        {
                            System.out.println("\nMaximum marks are : "+Aggregate_Max()+"\n");
                        }
                        else if("age".equals(Tokens[2]))
                        {
                            System.out.println("\nMaximum Age are : "+Aggregate_MaxAge()+"\n");
                        }
                        else
                        {
                            System.out.println("\nPlease enter the valid command. \n");
                        }
                    }
                    else if("min".equals(Tokens[1]))
                    {
                        if("marks".equals(Tokens[2]))
                        {
                            System.out.println("\nMinimum marks are : "+Aggregate_Min()+"\n");
                        }
                        else if("age".equals(Tokens[2]))
                        {
                            System.out.println("\nMinimum age is : "+Aggregate_MinAge()+"\n");
                        }
                        else
                        {
                            System.out.println("\nPlease enter the valid command. \n");
                        }
                    }
                    else if("avg".equals(Tokens[1]))
                    {
                        if("marks".equals(Tokens[2]))
                        {
                            System.out.println("\nAverage marks are : "+Aggregate_Avg()+"\n");
                        }
                        else if("age".equals(Tokens[2]))
                        {
                            System.out.println("\nAverage of age is : "+Aggregate_AvgAge()+"\n");
                        }
                        else
                        {
                            System.out.println("\nPlease enter the valid command. \n");
                        }
                    }
                    else if("sum".equals(Tokens[1]))
                    {
                        if("marks".equals(Tokens[2]))
                        {
                            System.out.println("\nSum of marks are : "+Aggregate_Sum()+"\n");
                        }
                        else if("age".equals(Tokens[2]))
                        {
                            System.out.println("\nSum of age is : "+Aggregate_SumAge()+"\n");
                        }
                        else
                        {
                            System.out.println("\nPlease enter the valid command. \n");
                        }
                    }
                    else
                    {
                        System.out.println("\nPlease enter the valid command. \n");
                    }
                }
            }
            else if(TokensCount == 6)
            {
                if("select".equals(Tokens[0]))
                {
                    System.out.println("\nTotal records count in the table is : "+Aggregate_CountTotalRecord()+"\n");
                }
                else
                {
                    System.out.println("\nPlease enter the valid command. \n");
                }
            }      
            else if(TokensCount == 7)
            {
                if("insert".equals(Tokens[0]))
                {
                    InsertIntoTable(Tokens[4], Integer.parseInt(Tokens[5]), Integer.parseInt(Tokens[6]));
                }
                else if("delete".equals(Tokens[0]))
                {
                    DeleteFrom(Integer.parseInt(Tokens[6]));
                }
                else
                {
                    System.out.println("\nPlease enter the valid command. \n");
                }
            }
            else if(TokensCount == 8)
            {
                 if("select".equals(Tokens[0]))
                 {
                    if("rollno".equals(Tokens[5]))
                    {
                        SelectFrom( Integer.parseInt(Tokens[7]));
                    }
                    else if("name".equals(Tokens[5]))
                    { 
                        SelectFrom(Tokens[7]);
                    } 
                    else if(("count".equals(Tokens[1]))||("name".equals(Tokens[5])))
                    { 
                        int iRet = Aggregate_CountNameRecord(Tokens[7]);
                        System.out.println("\nTotal number of count from student where name = "+Tokens[7]+" is : "+iRet);
                    } 
                    else
                    {
                        System.out.println("\nPlease enter the valid command. \n");
                    }
                 }
            }
            else
            {
                System.out.println("\nPlease enter the valid command. \n");
            }
        }
    }

   //--------------------------------------------------------------
   // insert into table student values(______, _______, _______);  ss
   
    public void InsertIntoTable(String Name, int Age, int Marks)
    {
        Student sobj = new Student(Name, Age, Marks);
        lobj.add(sobj); // Use add readymade function (InsertLast)
    }

   //--------------------------------------------------------------
   // Select * from Student         ss

    public void SelectFrom()
    {
        System.out.println("\nRecords from student table are :\n");
        
        System.out.println("+-------------------------------------------------");
        for(Student sref : lobj) // for each, sref is a object
        {
            sref.Display();
        }
    }

   //--------------------------------------------------------------
   // select * from student where Rno = 11     ss

   public void SelectFrom( int Rno)   // overloadind
    {
        System.out.println("\nRecords from student where Roll number "+Rno+" is : \n");

        for(Student sref : lobj) // for each, sref is a object
        {
            if( sref.RollNo == Rno)
            {
                System.out.println("+-------------------------------------------------");
                sref.Display();
                break;
            }
        }
    }

   //--------------------------------------------------------------
   // select * from student where Name = Sagar      ss

    public void SelectFrom( String name)   // overloadind
    {
        System.out.println("\nRecords from student where name "+name+" is : \n");
      
        for(Student sref : lobj) // for each, sref is a object
        {
            if( sref.Name.equalsIgnoreCase(name))
            {
                System.out.println("+-------------------------------------------------");
                sref.Display();
            }
        }
    }
   
   //--------------------------------------------------------------
   // Delete from student where RollNo = 3      ss

    public void DeleteFrom(int Rno)
    {
        int i = 0; 

        for(Student sref : lobj) 
        {
            if( sref.RollNo == Rno)
            {
                lobj.remove(i);   // use readymade method remove for delete specific Node
                break;
            }
            i++;
        }

    }

   //--------------------------------------------------------------
   // select MAX marks from student       ss

    public int Aggregate_Max()
    {
        Student Temp = lobj.get(0);   // use get readymade method for first index deta
        int iMax = Temp.Marks;        // for each, sref is a object
        
        for(Student sref : lobj)      // for each, sref is a object
        {
            if( sref.Marks > iMax)
            {
                iMax = sref.Marks;
            }
        }
        return iMax;
    }
   
   //--------------------------------------------------------------
   // select MAX age from student       ss

    public int Aggregate_MaxAge()
    {
        Student Temp = lobj.get(0);   // use get readymade method for first index deta
        int iMax = Temp.Age;        // for each, sref is a object
        
        for(Student sref : lobj)      // for each, sref is a object
        {
            if( sref.Age > iMax)
            {
                iMax = sref.Age;
            }
        }
        return iMax;
    }

   //--------------------------------------------------------------
   // select MIN(marks) from student          ss

    public int Aggregate_Min()
    {
        Student Temp = lobj.get(0);
        int iMin = Temp.Marks;

        for(Student sref : lobj) // for each, sref is a object
        {
            if( sref.Marks < iMin)
            {
                iMin = sref.Marks;
            }
        }
        return iMin;
    }

   //--------------------------------------------------------------
   // select MIN age from student         ss

    public int Aggregate_MinAge()
    {
        Student Temp = lobj.get(0);
        int iMin = Temp.Age;

        for(Student sref : lobj) // for each, sref is a object
        {
            if( sref.Age < iMin)
            {
                iMin = sref.Age;
            }
        }
        return iMin;
    }

   //--------------------------------------------------------------
   // select Sum marks from student         ss

    public int Aggregate_Sum()
    {
        int iSum = 0;

        for(Student sref : lobj) // for each, sref is a object
        {
            iSum = iSum + sref.Marks;
        }
        return iSum;
    }

   //--------------------------------------------------------------
   // select Sum age from student         ss

    public int Aggregate_SumAge()
    {
        int iSum = 0;

        for(Student sref : lobj) // for each, sref is a object
        {
            iSum = iSum + sref.Age;
        }
        return iSum;
    }

   //--------------------------------------------------------------
   // select Average marks from student          ss

    public float Aggregate_Avg()
    {
        int iSum = 0;

        for(Student sref : lobj) // for each, sref is a object
        {
            iSum = iSum + sref.Marks;
        }
        return (iSum / lobj.size());  // size method is works like a length method
    }

   //--------------------------------------------------------------
   // select Average age from student            ss

    public float Aggregate_AvgAge()
    {
        int iSum = 0;

        for(Student sref : lobj) // for each, sref is a object
        {
            iSum = iSum + sref.Age;
        }
        return (iSum / lobj.size());  // size method is works like a length method
    }

   //--------------------------------------------------------------
   // select count of record from student    ss

    public int Aggregate_CountTotalRecord()
    {
        int iCount = 0;

        for(Student sref : lobj) // for each, sref is a object
        {
            iCount++;
        }
        return iCount;
    }

   //--------------------------------------------------------------
   // select count of record from student where name = Sagar;  ss

    public int Aggregate_CountNameRecord(String name)
    {
        int iCount = 0;

        for(Student sref : lobj) // for each, sref is a object
        {
            if( sref.Name.equalsIgnoreCase(name))
            {
                iCount++;
            }
        }
        return iCount;
    }
   
}

/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

class Student
{
    // Columns of tables

    public int RollNo;
    public String Name;
    public int Age;
    public int Marks; 

    public static int Generator;  // static veriable

    static                  // Static block
    {
        Generator = 0;
    }

    public Student( String str, int x, int y)
    {
        this.RollNo = ++Generator;
        this.Name = str;
        this.Age = x; 
        this.Marks = y;
    }
    public void Display()
    { 
        System.out.println("|"+this.RollNo +" "+this.Name+" "+this.Age+" "+this.Marks);
        System.out.println("+-------------------------------------------------");
    }
}

/////////////////////////////////////////////////////////////////////////////////////
