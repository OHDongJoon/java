// JavaScript source code
function sumAll() {
    var result = 0;
    var sum;
    if (arguments.length == 0) {
        result = -999;
    } else if (arguments.length >= 1) {
        for (idx = 0; idx < arguments.length; idx++) {
            //idx 0 ; idx가 방갯수보다 작을때까지 잡아돌리고 idx 1씩 증가 
            result += arguments[idx];
        }
    } 
    return result;
}