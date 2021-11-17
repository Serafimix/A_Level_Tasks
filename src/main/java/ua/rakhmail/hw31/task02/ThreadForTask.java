package ua.rakhmail.hw31.task02;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ThreadForTask implements Runnable{
    private List<Integer> numbers;
    private static int temp;

    public ThreadForTask(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getTemp(){
        return temp;
    }

    @Override
    public void run() {
        int count = simpleCount(numbers);
        temp += count;
        System.out.println(count);
    }

    private static boolean isSimple(int number) {
        boolean isSimple = number > 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number <= 1 || number % 2 == 0 || number % 3 == 0 || number % i == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }

    private static int simpleCount(List<Integer> numbers) {
        return (int) numbers.stream().filter(ThreadForTask::isSimple).count();
    }
}
