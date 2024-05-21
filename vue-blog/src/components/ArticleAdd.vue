<script setup>
import { ref } from 'vue';


const dataForm = ref({
  title: '',
  content: '',
  tag: '',
  category: '',
  userId:''
});

const handleAdd = ()=>{
  console.log(dataForm.value)
}

</script>

<template>

  <div class="content">

    <div class="add-form">
      <el-form :model="dataForm" label-width="260px" style="max-width: 600px;padding: 20px;">

        <el-form-item label="标题" prpo="title">
          <el-input v-model="dataForm.title" type="text" placeholder="请输入标题" clearable/>
        </el-form-item>

        <el-form-item label="内容" prop="content">
          <el-input v-model="dataForm.content" type="textarea" clearable :autosize="{ minRows: 10, maxRows: 30 }"
            placeholder="请输入内容" />
        </el-form-item>

        <el-form-item label="标签" prop="title">
          <el-input v-model="dataForm.tag" type="text" placeholder="请输入标签" clearable />
        </el-form-item>

        <el-form-item label="分类" prop="category"> 
          <el-input v-model="dataForm.category" type="text" placeholder="请输入分类" clearable />
        </el-form-item>

        <el-form-item>
          <div style="margin: 60px 0px 60px 160px;">
            <el-button type="primary" style="width: 80px;" @click="handleAdd()">确定</el-button>
            <el-button type="default" style="width: 80px;" >取消</el-button>
          </div>
        </el-form-item>

      </el-form>
    </div>

  </div>


</template>

<style scoped>
.add-form {
  height: 670px;
  width: 900px;
  margin: 0px auto;
  border: 1px solid black;
  background-color: antiquewhite;
}
</style>
