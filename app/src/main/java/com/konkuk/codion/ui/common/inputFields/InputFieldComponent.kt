package com.konkuk.codion.ui.common.inputFields

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Red
import java.util.Locale

@Composable
fun InputFieldComponent(
    label: String,
    isRequired: Boolean,
    placeholder: String,
    inputText: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    // 비밀번호 필드 관련
    isPwdField: Boolean = false,  // 해당 inputfield가 pwd를 다루는 필드인지 여부
    isPwdVisible: Boolean = true,  // 현재 보이는 상태인지에 대한 여부
    onTogglePwdVisibility: (() -> Unit)? = null,  // 숨김/안숨김 아이콘 클릭 시 호출할 콜백 함수
    // 타이머 관련
    showTimer: Boolean = false,
    timerSeconds: Int? = null
) {
    // 필수 입력 여부에 따른 '*' 텍스트 추가 or 미추가 처리
    val labelText = if (isRequired) "$label *" else label

    // 타이머 시간 '분:초' 형식 텍스트로 변환
    val formattedTime = timerSeconds?.let { seconds ->
        String.format(Locale.KOREA, "%02d:%02d", seconds / 60, seconds % 60)
    }

    Column(
        modifier = modifier
    ) {
        Text(
            text = labelText,
            style = CodiOnTypography.pretendard_600_14,
            color = Gray700
        )
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = inputText,
            onValueChange = onTextChange,
            modifier = Modifier
                .height(40.dp)
                .border(1.dp, Gray500, shape = RoundedCornerShape(6.dp))
                .padding(start = 10.dp, end = 10.dp),
            textStyle = CodiOnTypography.pretendard_400_14.copy(color = Gray700),
            visualTransformation = if (isPwdField && !isPwdVisible) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,  // 필드 내에서 엔터 사용 불가능 처리
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        // placeholder 노출 여부
                        if (inputText.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = CodiOnTypography.pretendard_400_14,
                                color = Gray500
                            )
                        }
                        innerTextField()
                    }
                    // 비밀번호 필드 여부
                    if (isPwdField && onTogglePwdVisibility != null) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clickable(onClick = onTogglePwdVisibility),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Icon(
                                painter = if (isPwdVisible) painterResource(R.drawable.ic_eye_off) else painterResource(
                                    R.drawable.ic_eye_on
                                ),
                                contentDescription = "눈 아이콘",
                                tint = Gray500,
                                modifier = Modifier.fillMaxHeight()
                            )
                        }
                    }
                    // timer 노출 여부
                    if (showTimer && formattedTime != null) {
                        Text(
                            text = formattedTime,
                            style = CodiOnTypography.pretendard_400_14,
                            color = Red
                        )
                    }
                }
            }
        )
    }
}

// 커서 정보까지 저장한 InputFieldComponent (InputFieldComponent 오버로딩한 버전)
@Composable
fun InputFieldComponent(
    label: String,
    isRequired: Boolean,
    placeholder: String,
    inputText: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
) {
    // 필수 입력 여부에 따른 '*' 텍스트 추가 or 미추가 처리
    val labelText = if (isRequired) "$label *" else label

    Column(
        modifier = modifier
    ) {
        Text(
            text = labelText,
            style = CodiOnTypography.pretendard_600_14,
            color = Gray700
        )
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = inputText,
            onValueChange = onTextChange,
            modifier = Modifier
                .height(40.dp)
                .border(1.dp, Gray500, shape = RoundedCornerShape(6.dp))
                .padding(start = 10.dp, end = 10.dp),
            textStyle = CodiOnTypography.pretendard_400_14.copy(color = Gray700),
            singleLine = true,  // 필드 내에서 엔터 사용 불가능 처리
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        // placeholder 노출 여부
                        if (inputText.text.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = CodiOnTypography.pretendard_400_14,
                                color = Gray500
                            )
                        }
                        innerTextField()
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun InputFieldComponentPreview() {
    var pwdInputTest1 by remember { mutableStateOf("") }
    var pwdInputTest2 by remember { mutableStateOf("") }
    var pwdInputTest3 by remember { mutableStateOf("") }
    var emailCodeInputTest1 by remember { mutableStateOf("") }
    var isPwdVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp), verticalArrangement = Arrangement.Center
    ) {
        // 기본 필드인 경우
        InputFieldComponent(
            label = stringResource(R.string.pwd),
            isRequired = false,
            placeholder = stringResource(R.string.pwd_ph),
            inputText = pwdInputTest1,
            onTextChange = { pwdInputTest1 = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 필수 입력 필드인 경우
        InputFieldComponent(
            label = stringResource(R.string.pwd),
            isRequired = true,
            placeholder = stringResource(R.string.pwd_ph_hint),
            inputText = pwdInputTest2,
            onTextChange = { pwdInputTest2 = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 비밀번호 필드인 경우
        InputFieldComponent(
            label = stringResource(R.string.pwd),
            isRequired = true,
            placeholder = stringResource(R.string.pwd_ph_hint),
            inputText = pwdInputTest3,
            onTextChange = { pwdInputTest3 = it },
            isPwdField = true,
            isPwdVisible = isPwdVisible,
            onTogglePwdVisibility = { isPwdVisible = !isPwdVisible }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // timer가 존재하는 필드인 경우
        InputFieldComponent(
            label = stringResource(R.string.code),
            isRequired = true,
            placeholder = stringResource(R.string.code_ph),
            inputText = emailCodeInputTest1,
            onTextChange = { emailCodeInputTest1 = it },
            showTimer = true,
            timerSeconds = 180
        )
    }
}