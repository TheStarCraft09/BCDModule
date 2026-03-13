package kotlin

class BinaryDecimalConverter {
    fun convert(binary: Int): Int {
        var BinaryToConvert: Int = binary
        var placeValue: Int = 0
        var decimal: Int = 0

        while(BinaryToConvert > 0) {
            var digit: Int = BinaryToConvert % 10
            decimal += digit * Math.pow(2.0, placeValue.toDouble()).toInt()
            BinaryToConvert /= 10
            placeValue++
        }

    return decimal
    }

}