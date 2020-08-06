<template>
  <section class="index-image-wrapper">
    <div
      class="index-image"
      v-for="(value, key, index) in map"
      :key="index"
      @click="routeto(key)"
    >
      <img style="width: 100px; height: 100px" :src="srcDeal(key)" />
      <span class="demonstration">{{ value }}</span>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      map: {
        roombook: "房间预订",
        checkin: "来客入住",
        checkout: "办理退房",
        orderlist: "订单列表",
        roomlist: "房间列表"
      },
      publicPath: process.env.BASE_URL
    };
  },
  methods: {
    srcDeal(src) {
      return `${this.publicPath}home/` + src + `.svg`;
    },
    routeto(key) {
      let str = key == "roombook" ? "/home/book" : "/home/" + key;
      this.$emit("getTitle", str);
      console.log(str);
      this.$router.push({
        path: str
      });
    }
  }
};
</script>

<style>
.index-image-wrapper {
  max-width: 800px;
  min-width: 650px;
}
.index-image {
  padding: 20px 0;
  padding-top: 40px;
  text-align: center;
  display: inline-block;
  width: 20%;
  box-sizing: border-box;
  vertical-align: top;
}
.index-image:hover {
  cursor: pointer;
}
.demonstration {
  display: block;
  margin-top: 15px;
  font-weight: 700;
}
</style>
