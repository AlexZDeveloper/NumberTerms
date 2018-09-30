/*
Задача 130: Разбиение числа
Задача: давайте вспомним одну из популярных задач на вывод всех разбиений числа N. 
Разбиения числа N на слагаемые — это набор целых положительных чисел, сумма которых равна N. При этом разбиения, отличающиеся лишь порядком слагаемых, считаются одинаковыми.
Необходимо вывести всевозможные разбиения N.
Условие: слагаемые в разбиениях должны идти в невозрастающем порядке.
Входные данные: N - натуральное число от 1 до 30.
Вывод: всевозможные разбиения числа N
Пример: N = 3
Answer: 
1 + 1 + 1
2 + 1
3
 * */
import java.util.ArrayList;
import java.util.List;

public class NumberTerms {
	
	public static void splitNumber(int n) {
		splitNumber(n, n, new ArrayList<Integer>());
	}
	
	private static void splitNumber(int n, int maxNumber, List<Integer> termsList) {
		if (n == 0) {
			print(termsList);
			return;
		}		
		for (int i = 1; (i <= n) && (i <= maxNumber); i++) {
			List<Integer> newTermsList = new ArrayList<Integer>(termsList);
			newTermsList.add(i);
			splitNumber(n - i, i, newTermsList);
		}
	}
	
	private static void print(List<Integer> sub) {
		StringBuilder builder = new StringBuilder();
		sub.forEach(x -> builder.append(x).append(" + "));
		String s = builder.toString(); 
		System.out.println(s.substring(0, s.length() - 3));
	}	
	
	public static void main(String[] args) {
		System.out.println("Splitting number 3 into terms");
		splitNumber(3);
		System.out.println("Splitting number 10 into terms");
		splitNumber(10);
	}
}
