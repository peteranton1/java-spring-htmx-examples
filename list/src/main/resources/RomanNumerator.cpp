#include <iostream>
#include <string>

std::string toRoman(int num) {
    struct Roman {
        int value;
        const char* numeral;
    };
    const Roman roman[] = {
        {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"},
        {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"},
        {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}
    };

    std::string result;
    for (const auto& r : roman) {
        while (num >= r.value) {
            result += r.numeral;
            num -= r.value;
        }
    }
    return result;
}

int main() {
    int number;
    std::cout << "Enter a decimal number: ";
    std::cin >> number;

    if (number > 0 && number <= 3999) {
        std::cout << "Roman numeral: " << toRoman(number) << std::endl;
    } else {
        std::cout << "Number out of range (1-3999)!" << std::endl;
    }

    return 0;
}
