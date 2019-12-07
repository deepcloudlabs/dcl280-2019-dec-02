package com.example.banking.app;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyString {

	public static void main(String[] args) {
		String s1 = "Jack";
		String s2 = new String("Jack");
		String s3 = "Jack";
		s2 = s2.intern();
		System.out.println("s1==s2: " + (s1 == s2));
		System.out.println("s1==s3: " + (s1 == s3));
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("s1.equals(s3): " + s1.equals(s3));
		System.out.println("s3: " + s3);
		String s4 = s3.toUpperCase();
		System.out.println("s3: " + s3);
		System.out.println("s4: " + s4);
		StringBuilder s5 = new StringBuilder(488880);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100_000; ++i) {
			s5.append(Integer.toString(i));
		}
		System.out.println(s5.length());
		long stop = System.currentTimeMillis();
		System.out.println("Duration: " + (stop - start));
	}

}
