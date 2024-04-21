<script setup>


import { reactive, ref } from 'vue';
import {useRouter} from 'vue-router';
const dataFormRef = ref();

const dataForm = reactive({
    username: "",
    password: "",
})
const router = useRouter();
// 添加验证
const rules = reactive({
    username: [
        { required: true, message: '请输入账号', trigger: 'blur' },
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
    ]
})

// 登入
const login = function () {
    router.push(
        {
            path: '/main',
        }
    )
}

</script>

<template>
    <div class="container">
        <el-form v-model="dataForm" ref="dataFormRef" :rules="rules" class="loginForm">

            <el-form-item prop="username">
                <el-input v-model="dataForm.username" style="width: 240px" clearable type="text" placeholder="请输入账号">
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
            </el-form-item>
            <el-form-item label="没有账号">
                <routerLink to="/register">点我注册</routerLink>
            </el-form-item>
        </el-form>
    </div>
</template>

<style scoped>
.container {
    width: 100%;
    height: 600px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.loginForm {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 400px;
    height: 400px;
    border-radius: 15%;
    background-color: rgb(127, 251, 255);

}
</style>
