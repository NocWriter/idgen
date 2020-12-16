# Identifiers generator (IdGen)

Efficient library for safely generating unique identifiers.

## Usage

The library provides an abstraction represented as an interface: `IdGenerator`:

```java
IdGenerator generator = ...

String uniqueId = generator.generate()

```

You can use any of the provided implementation as your generator:

```java
IdGenerator generator = new SecureRandomIdGenerator()
```

## System requirements

Requires Java 1.8 and above.

## The Secure-random generator

Perhaps the most appealing (and the centric part of this library) is the `SecureRandomIdGenerator` generator. It is
considered as the most reliable way to generate unique identifiers (numbers of otherwise) at any given length and with any
given alphabet.

By default, it is configured to generate tokens of 24 characters long with an alphabet containing all digits and all
alphabet characters (i.e.: 0-9, a-z, A-Z), e.g.: `AJO8rSj0X4qPnfrqUq6NDrBk`.

You can control the length of the token either via a constructor (e.g.: `new SecureRandomIdGenerator(<size>)`) or via an
accessor (e.g.: `generator.setTokenSize(<size>`)).

You can also control the alphabet in the same way (e.g., for using digits-only random generator:
`generator.setTokenEncodingAlphabet("0123456789".toCharArray())`).

This implementation is efficient in both execution time and in resources.

## Frequently asked questions

Please refer to our [FAQ](./faq.md) section for more information on why you should use this library.

## License

This library is distributed under the [https://en.wikipedia.org/wiki/MIT_License|MIT license]. It can be freely used,
reused and used more-and-more-and-more. As much as you like it. You may even copy parts of the code for your own use. If
possible, don't forget to credit me (it's not mandatory, but it's very polite).

## Contacting the author

If you have special request or an interesting question, you are more than welcome to open a ticket in this repository
and I'll get back to you. 