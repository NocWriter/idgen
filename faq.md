

## Why do I need it?

You may need this library for 2 main reasons:

* Firstly, Java's RNG (Random number generator) has a low-quality random stream generator. It uses the
  [https://en.wikipedia.org/wiki/Linear_congruential_generator|Linear congruential generator], which is not bad for
  testing, but it cannot be used in serious productions. You cannot rely on it to be genuine over a long period of time.

* Secondly, Java does not provide sufficient means to address all use cases. For example, Java cannot produce
  access-token like random values (e.g.: `eaUaM627KqH3sHB4GnyeL6C`).

## Why not use UUID?

Java's implementation of UUID is based mainly Leach-Salz variant. In practice, Java's implementation is based on
system's [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/UUID.html|timestamp] (which means that
UUID is mostly composed of the system timestamp). As a general internal non-production identifiers, Java UUIDs are
pretty good. The chance of collision is almost none, however, in actual productions, it may impose various limitations:

* The UUID exposes the server's timestamp, which is a security issue.
* The token length is limited (always 128-bits).
* The alphabet is always known (i.e.: 0-9, A-Z). You cannot create complex tokens such as `eaUaM627KqH3sHB4GnyeL6C`.

