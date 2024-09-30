# JSON Parser

This Java program provides a function to parse any valid JSON string into a corresponding `Object`, `List`, or `Map` object. It supports arbitrary precision for integers and floating-point numbers.

## Assumptions

- The entire input must be provided in a single line.

## Usage

To use the JSON parser, simply call the `parseJson` method with a valid JSON string.

### Example Tests

Here are some examples of how the parser handles different JSON inputs:

1. **Valid JSON with BigInteger and BigDecimal:**

   **Input:**

{ "bigInt": 92233720368547758071234, "bigFloat": 1234567890.12345678901234567890}


**Parsed Result:**
{bigInt=92233720368547758071234, bigFloat=1234567890.12345678901234567890}


2. **Invalid JSON (missing quotes around keys):**

**Input:**
{name: "Akash"}


**Output:**
Error: Failed to parse JSON string


3. **Empty Input:**

**Input:**

**Output:**
Error: Empty input. Please provide a valid JSON string.


4. **Valid JSON Array:**

**Input:**
[1, 2, 9223372036854775808, 3.141592653589793238462643383279]


**Parsed Result:**

[1, 2, 9223372036854775808, 3.141592653589793238462643383279]


5. **Valid JSON with Mixed Types:**

**Input:**
{"name": "Akash", "age": 92233720368547758071234, "balance": 1234567890.12345678901234567890}



**Parsed Result:**
{name=Akash, age=92233720368547758071234, balance=1234567890.12345678901234567890}


6. **Invalid JSON (syntax error):**

**Input:**
{akash",9}


**Output:**
Error: Failed to parse JSON string

