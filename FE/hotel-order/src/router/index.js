import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "/home"
  },
  {
    path: "/login",
    name: "hogin",
    component: () => import("../views/login/login.vue")
  },
  {
    path: "/home",
    component: () => import("../views/home/home.vue"),
    children: [
      {
        path: "/",
        name: "home",
        component: () => import("../views/home/index/index.vue")
      },
      {
        path: "/home/book",
        component: () => import("../views/home/book/book/book.vue")
      },
      {
        path: "/home/booklist",
        component: () => import("../views/home/book/booklist/booklist.vue")
      },
      {
        path: "/home/checkin",
        component: () => import("../views/home/checkin/checkin.vue")
      },
      {
        path: "/home/checkout",
        component: () => import("../views/home/checkout/checkout.vue")
      },
      {
        path: "/home/orderlist",
        component: () => import("../views/home/orderlist/orderlist.vue")
      },
      {
        path: "/home/roomlist",
        component: () => import("../views/home/roomlist/roomlist.vue")
      }
    ]
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
