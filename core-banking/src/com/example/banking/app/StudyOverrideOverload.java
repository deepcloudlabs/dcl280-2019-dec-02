package com.example.banking.app;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyOverrideOverload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class A<T> {
	T fun() {
		return null;
	}
}

class B extends A<M> {
	@Override
	N fun() {
		return null;
	}
}

class M {
}

class N extends M {
}