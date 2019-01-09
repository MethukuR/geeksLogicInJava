package com.buildingLogic.numberSpecial;

public class HashFunction {

	public static void main(String[] args) {
		System.out.println(hashCode("abcd".toCharArray(), 100));
	}

	/**
	 * @param key: A String you should hash
	 * @param HASH_SIZE: An integer
	 * @return an integer
	 */
	public static int hashCode(char[] key, int HASH_SIZE) {
		if (key.length == 0) {
			return 0;
		}
		long hashRst = 0;
		for (int i = 0; i < key.length; i++) {
			hashRst = hashRst * 33 + (int) (key[i]);
			hashRst = hashRst % HASH_SIZE;
		}
		return (int) hashRst;

	}
}
