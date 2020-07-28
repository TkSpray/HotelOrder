<template>
  <section class="section">
    <orderTable :orderlist="orderlist" :type="2" />
  </section>
</template>

<script>
import orderTable from "../../../../components/orderTable";

export default {
  components: {
    orderTable
  },
  data() {
    return {
      orderlist: []
    };
  },
  mounted() {
    this.orderlist = this.$store.state.orderlist.filter(
      order => order.orderstatus == 0
    );
  },
  methods: {}
};
</script>

<style></style>
