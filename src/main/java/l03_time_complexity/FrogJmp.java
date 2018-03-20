package l03_time_complexity;

public class FrogJmp {
	
	public int solution(int X, int Y, int D) {
        int steps = (int)Math.ceil((double)(Y - X) / (double)D);
        return steps;
    }

	public static void main(String[] args) {
		FrogJmp s = new FrogJmp();
		System.out.println(s.solution(10, 85, 30));
	}
}
