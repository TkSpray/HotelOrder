<template>
  <section>
    <div class="block" v-for="(value, key, index) in fits" :key="index">
      <el-image
        style="width: 100px; height: 100px"
        :src="'../../../../assets/home/' + key"
        :fit="fit"
      ></el-image>
      <span class="demonstration">{{ value }}</span>
      =
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      map: {
        roombook: '房间预订',
        checkin: '来客入住',
        checkout: '办理退房',
        orderlist: '订单列表',
        roomlist: '房间列表',
      },
    }
  },
}
</script>

<style></style>
