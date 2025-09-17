<script setup lang="ts">

import Header from '@/layout/Header.vue'
import Silder from '@/layout/Silder.vue'
</script>

<template>
  <div class="common-layout" >
    <el-container>
      <el-aside width="200px">
        <Silder></Silder>
      </el-aside>
      <el-container>
        <el-header style="padding: 10px">
          <Header></Header>
        </el-header>
        <el-main style="border: 1px red solid">
          <RouterView/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
</style>
