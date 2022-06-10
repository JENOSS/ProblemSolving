import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 [10825] [정렬] 국영수
 **/

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static Student[] students;

    static class Student implements Comparable<Student>{
        String name;
        int kor, eng, math;

        Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            // 국어 영어 수학 이름 값을 가지고 정렬 기준 정의
            if(kor != o.kor) return o.kor - kor;
            if(eng != o.eng) return eng - o.eng;
            if(math != o. math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        students = new Student[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine()," ");
            Student student = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            students[i] = student;
        }
    }

    static void run(){
        Arrays.sort(students);
        for(int i = 0; i < N; i++){
            sb.append(students[i].name).append("\n");
        }
        System.out.print(sb.toString());
    }
}