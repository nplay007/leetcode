class Solution(object): 
    def strongPasswordChecker(self, s):
        start, end = 0, 0
        length_change = 0
        if len(s) < 6: length_change = 6 - len(s)
        if len(s) > 20: length_change = len(s) - 20
        lower_flag = 1
        upper_flag = 1
        digit_flag = 1
        repeats = []
        while end < len(s):
            while end < len(s) and s[start] == s[end]:
                if s[end].isdigit(): digit_flag = 0
                elif s[end].isupper(): upper_flag = 0
                elif s[end].islower(): lower_flag = 0
                end += 1
            if end - start >= 3:
                repeats.append(end-start)
            start = end
        repeats.sort()
        other_change = lower_flag + upper_flag + digit_flag
        length_repeat = 0
        if len(s) > 20:
            while repeats and length_change:
                length_repeat += 1  # make one delete, count increment by 1
                repeats[0] -= 1     # repeats part decrement by 1
                length_change -= 1  # solve one `length problem`
                if repeats[0] < 3:
                    repeats.pop(0)  # if length of repeating part is less than 3, this part is totally solved
        if len(s) < 6:
            while repeats and length_change:
                length_repeat += 1    # make one insert, count increment by 1
                repeats[0] -= 2       # repeats part decrement by 2
                length_change -= 1    # solve one `length problem`
                if other_change > 0:  # solve one `other problem`
                    other_change -= 1
                if repeats[0] < 3:    # if length of repeating part is less than 3, this part is totally solved
                    repeats.pop(0)
        # till now, we are sure that we have solved at least one of `repeat problem` or `length problem`
        # if there is still `repeat problem` left, count it and solve it with replace operation
        repeat_left = 0
        for repeat in repeats:
            repeat_left += repeat / 3

        # what left is length_repeat(fixed), other_change(replace/ins), length_change(ins/del) or repeat_left(replace)
        if len(s) > 20:
            # length_change could only be solved by deletion
            if length_change:
                return length_repeat + other_change + length_change
            else:
                return length_repeat + max(other_change, repeat_left)
        else:
            # length_change could be solved by ins
            if length_change:
                return length_repeat + max(other_change, length_change)
            else:
                return length_repeat + max(other_change, repeat_left)