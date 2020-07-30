<template>
  <section class="section">
    <orderTable :orderlist="orderlist" :type="1" />
  </section>
</template>

<script>
import orderTable from "../../../components/orderTable";

export default {
  components: {
    orderTable
  },
  data() {
    return {};
  },
  computed: {
    orderlist() {
      return this.$store.state.orderlist.filter(order => order.orderstate == 1);
    }
  },
  methods: {}
};
</script>

<style></style>
