package club.banyuan.demo;

import java.util.Scanner;

/**
 * 使用数组完成学生管理系统
 * 要求:
 *
 * 设计一个：学生管理系统
     1.添加学生信息\n
     2.显示学生信息\n    显示所有学生信息
     3.删除学生信息\n   根据学生id删除学生信息
     4.修改学生信息\n   根据学生id修改学生信息
     5.查看学生信息\n   查看的条件自定义
     6.排序\n  （请选择排序方法:1.按学号排序\t2.按成绩排序）
     7.退出
     学生信息有 学生id  学生姓名stuName  学生成绩stuScore (使用数组存储数据)
    完成上述要求
 */

public class Main {

    public static void main(String[] args) {


            String [] id=new String[50];
            String [] stuName=new String[50];
            String [] stuScore=new String[50];
            int number=-1;
            int  stuCount=0;

        System.out.println("欢迎进入学生管理系统\n1.添加学生信息\n2.显示学生信息\n" +
            "3.删除学生信息\n4.修改学生信息\n5.查询学生信息\n6.排序\n7.退出");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入选择：");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    stuCount=addStuInformation(id,stuName,stuScore,stuCount);
                    System.out.println("添加成功");
                    break;
                case 2:
                    showStuInfo(id,stuName,stuScore,stuCount);
                    break;
                case 3:
                    stuCount=deleteStuByStuId(id,stuName,stuScore,stuCount);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    sortByStudentId(id,stuName,stuScore,stuCount);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入1-7之间的整数");
                    break;
            }
        }

    }

    /**
     *
     * @param studentId 学生id
     * @param studentName 学生姓名
     * @param stuScore 学生成绩
     * @param stuCount 统计学生个数
     */
    public static  int  addStuInformation(String[] studentId,String[] studentName,String []stuScore,int stuCount){

        if(studentId==null||studentName==null||stuScore==null){
            System.out.println("没有可存储 容器");
            return -1;
        }

        System.out.println("请输入学生学号");
        Scanner scanner1 = new Scanner(System.in);
        studentId[stuCount] = scanner1.next();
        System.out.println("请输入学生姓名");
        //Scanner scanner2= new Scanner(System.in);
        studentName[stuCount] = scanner1.next();
        System.out.println("请输入学生成绩");
       // Scanner scanner3 = new Scanner(System.in);
        stuScore[stuCount] = scanner1.next();
        stuCount++;
        return stuCount;

        /*
           需求增加:可以对学号进行限制 比如说以 "100"+数字
         */
    }

    /**
     *  显示所有学生的信息
     * @param studentId
     * @param studentName
     * @param stuScore
     * @param stuCount
     */
    public  static  void  showStuInfo(String[] studentId,String[] studentName,String []stuScore,int stuCount){
        if(stuCount==0){
            System.out.println("数据为空");
            return ;
        }
        for (int i = 0; i < stuCount; i++) {
            System.out.println("第"+(i+1)+"学生的学号为:"+studentId[i]+",姓名为:"+studentName[i]
                +",成绩为:"+stuScore[i]);
        }
    }


    public  static int  deleteStuByStuId(String[] studentId,String[] studentName,String []stuScore,int stuCount){
        if(stuCount==0){
            System.out.println("数据为空");
            return stuCount;
        }

        System.out.println("是否要进行删除？Y/N");
        Scanner  scanner=new Scanner(System.in);
        String  flag=scanner.next();
        if(!flag.equalsIgnoreCase("Y")){
            return stuCount;
        }
        //显示所有学生信息 方便选择
        showStuInfo(studentId,studentName,stuScore,stuCount);

        System.out.println("请输入要删除的学生编号:");
        String  strNumber=scanner.next();

        for (int i = 0; i < stuCount; i++) {
            if(strNumber.equals(studentId[i])){  //字符串内容的比较
                if(i<stuCount-1){
                    studentId[i]=studentId[i+1];
                    studentName[i]=studentName[i+1];
                    stuScore[i]=stuScore[i+1];
                }

                if(i==stuCount-1){
                    studentId[i]=null;
                    studentName[i]=null;
                    stuScore[i]=null;
                    stuCount--;
                }
            }
        }

        return stuCount;
    }


    /**
     * 根据学生的学号或者得分进行排序  显示出对应的学生信息
     * @param studentId
     * @param studentName
     * @param stuScore
     * @param stuCount
     */
    public  static  void  sortByStudentId(String[] studentId,String[] studentName,String []stuScore,int stuCount){

        if(stuCount==0){
            System.out.println("数据为空");
            return;
        }

        System.out.println("请输入排序条件:\t 1.学号 \t2.得分");
        Scanner  scanner=new Scanner(System.in);
        String temp=null;
        String   number=scanner.next();
        switch (number){
            case "1":
                for (int i = 0; i < stuCount; i++) {
                    for (int j = 0; j < stuCount-1-i; j++) { //"12345"  ---->>> 12345
                        if( Integer.parseInt(studentId[j]) > Integer.parseInt(studentId[j+1]) ){
                            temp=studentId[j];
                            studentId[j]=studentId[j+1];
                            studentId[j+1]=temp;

                            //姓名交换
                            temp=studentName[j];
                            studentName[j]=studentName[j+1];
                            studentName[j+1]=temp;


                            //成绩交换
                            temp=stuScore[j];
                            stuScore[j]=stuScore[j+1];
                            stuScore[j+1]=temp;

                        }
                    }
                }
                showStuInfo(studentId,studentName,stuScore,stuCount);
                break;
            case "2":
                for (int i = 0; i < stuCount; i++) {
                    for (int j = 0; j < stuCount-1-i; j++) {
                        if( Double.parseDouble(stuScore[j]) > Double.parseDouble(stuScore[j+1]) ){
                            temp=stuScore[j];
                            stuScore[j]=stuScore[j+1];
                            stuScore[j+1]=temp;

                            //姓名交换
                            temp=studentName[j];
                            studentName[j]=studentName[j+1];
                            studentName[j+1]=temp;

                            //id交换
                            temp=studentId[j];
                            studentId[j]=studentId[j+1];
                            studentId[j+1]=temp;

                        }
                    }
                }
                showStuInfo(studentId,studentName,stuScore,stuCount);
                break;
            default:
                System.err.println("输入有误!!!");
                break;
        }

    }

}
