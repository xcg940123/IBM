package cn.mics.brank.tes;

import static java.lang.String.format;

public class Out {
	static void out(String format, Object... args) {

        System.err.flush();
        System.out.flush();

        System.out.println(format(format, args));
        System.err.flush();
        System.out.flush();

    }
}
