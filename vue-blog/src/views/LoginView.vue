<script setup>


import { ref } from 'vue';
import { useRouter } from 'vue-router';


const message = ref();
const isRegister = ref(false);
const dataForm = ref({
    username: '',
    password: '',
    rePassword: ''
})
const router = useRouter();
// 添加验证
const rules = {
    username: [
        { required: true, message: '请输入用户名', trigger: 'blur' },
        { min: 5, max: 16, message: '长度为5~16数字', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
        { min: 5, max: 16, message: '长度为5~16位非空字符', trigger: 'blur' }
    ],
    // rePassword: [
    //     { validator: checkRePassword, trigger: 'blur' }
    // ]
}
const clearDataForm = () => {
    dataForm.value = {
        username: '',
        password: '',
    }
}

// //检查密码是否一致
// const checkRePassword = (rule, value, callback) => {
//     if (value === '') {
//         callback(new Error('请再次确认密码'))
//     } else if (value !== dataForm.value.password) {
//         callback(new Error('请确保两次输入的密码一样'))
//     } else {
//         callback()
//     }
// }

import { inject } from 'vue';

const axios = inject("$axios");
// 登入
const login = () => {
    const param = {
        username: dataForm.value.username,
        password: dataForm.value.password
    }
    axios.post('http://localhost:8080/login', param).then((res) => {
        let flag = res.data.flag;
        message.value = res.data.message;

        if (flag) {
            //登入成功
            alert(message.value);
            router.push(
                {
                    path: '/main',
                }
            )
        } else {
            alert(message.value);
            router.push(
                {
                    path: '/'
                }
            )
        }

    })


}

const register = () => {

    console.log("register")
}

</script>

<template>
    <div class="container">
        <div class="form-box">
            <!-- 登入表单 -->
            <el-form :model="dataForm" ref="dataForm1" v-if="!isRegister" :rules="rules" class="Form">

                <el-form-item prop="username">
                    <el-input v-model="dataForm.username" style="width: 240px" clearable type="text"
                        placeholder="请输入账号">
                        <template #prefix>
                            <el-icon>
                                <User />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="dataForm.password" style="width: 240px" type="password" placeholder="请输入密码"
                        show-password>
                        <template #prefix>
                            <el-icon>
                                <Lock />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="login()">登入</el-button>
                    <el-button type="primary" @click="isRegister = true; clearDataForm()">注册</el-button>
                </el-form-item>
            </el-form>

            <!-- 注册表单 -->
            <el-form v-model="dataForm" ref="dataFormRef" v-else :rules="rules" class="Form">

                <el-form-item prop="username">
                    <el-input v-model="dataForm.username" style="width: 240px" clearable type="text"
                        placeholder="请输入账号">
                        <template #prefix>
                            <el-icon>
                                <User />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="dataForm.password" style="width: 240px" type="password" placeholder="请输入密码"
                        show-password>
                        <template #prefix>
                            <el-icon>
                                <Lock />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="rePassword">
                    <el-input v-model="dataForm.rePassword" style="width: 240px" type="password" placeholder="请再次输入密码"
                        show-password>
                        <template #prefix>
                            <el-icon>
                                <Lock />
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="isRegister = false; register()">确定</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<style scoped>
.form-box {
    width: 100%;
    height: 700px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    
}

.Form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 400px;
    height: 400px;
    border-radius: 10%;
    background-color:rgba(255, 255, 255, 0.5)
}

.container{
    width: 100%;
    height: 100%;
    background-image: url('@/assets/img/bg.jpg');
    background-size: cover;
}

</style>
