// JavaScript source code
function sumAll() {
    var result = 0;
    var sum;
    if (arguments.length == 0) {
        result = -999;
    } else if (arguments.length >= 1) {
        for (idx = 0; idx < arguments.length; idx++) {
            //idx 0 ; idx�� �氹������ ���������� ��Ƶ����� idx 1�� ���� 
            result += arguments[idx];
        }
    } 
    return result;
}