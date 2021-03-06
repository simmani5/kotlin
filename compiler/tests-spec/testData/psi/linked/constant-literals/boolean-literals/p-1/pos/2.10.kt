/*
 KOTLIN PSI SPEC TEST (POSITIVE)

 SECTIONS: constant-literals, boolean-literals
 PARAGRAPH: 1
 SENTENCE: [2] These are strong keywords which cannot be used as identifiers unless escaped.
 NUMBER: 10
 DESCRIPTION: The use of Boolean literals as the identifier (with backtick) in the companionObject.
 NOTE: this test data is generated by FeatureInteractionTestDataGenerator. DO NOT MODIFY CODE MANUALLY!
 */

class A {
    companion object `true` {

    }
}

class B {
    companion object `false`: A() {

    }
}

class C {
    companion object `true`: B by expr, x1, A() {

    }
}
