package jiyun.lwj.com.mvp.bean;

import java.util.List;

/**
 * Created by 她说 on 2019/3/2.
 */

public class ZhiRiBean {
    /**
     * date : 20190302
     * stories : [{"title":"只用 VR 来看电影，那真是大材小用了","ga_prefix":"030209","images":["https://pic1.zhimg.com/v2-0322d5287a9f0a5563096f2d86473170.jpg"],"multipic":true,"type":0,"id":9708337},{"images":["https://pic4.zhimg.com/v2-8a37ae16f05d9f1f0df088d346d6e703.jpg"],"type":0,"id":9708251,"ga_prefix":"030208","title":"县城手机游戏有多野？"},{"images":["https://pic2.zhimg.com/v2-f7697f4c75e1d619b31ed6dcca25a841.jpg"],"type":0,"id":9708367,"ga_prefix":"030207","title":"取消公摊是在保护买房人？我有点想呵呵"},{"images":["https://pic4.zhimg.com/v2-5b9f74669f25f13d850fefefe59b529f.jpg"],"type":0,"id":9708295,"ga_prefix":"030206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-813b997f827f4dd4a4e511a6506e4d35.jpg","type":0,"id":9708038,"ga_prefix":"030121","title":"一个接一个，漫威的这些梗我是快招架不住了"},{"image":"https://pic1.zhimg.com/v2-e201ee5ec7aa14b3cbdb78bb6466e34c.jpg","type":0,"id":9708367,"ga_prefix":"030207","title":"取消公摊是在保护买房人？我有点想呵呵"},{"image":"https://pic4.zhimg.com/v2-4952a40ce6ce98df54a072bd53af432b.jpg","type":0,"id":9708298,"ga_prefix":"030108","title":"临沂没有网戒中心"},{"image":"https://pic4.zhimg.com/v2-7ec9f61856b088babc03b9cb3053b34f.jpg","type":0,"id":9708279,"ga_prefix":"022815","title":"万元抗癌药被认定为假药，仿佛「药神」走进了现实"},{"image":"https://pic1.zhimg.com/v2-8b4ed8b534a72d16aad77b1e4d6db040.jpg","type":0,"id":9708256,"ga_prefix":"022807","title":"星巴克的「圣杯战争」"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 只用 VR 来看电影，那真是大材小用了
         * ga_prefix : 030209
         * images : ["https://pic1.zhimg.com/v2-0322d5287a9f0a5563096f2d86473170.jpg"]
         * multipic : true
         * type : 0
         * id : 9708337
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-813b997f827f4dd4a4e511a6506e4d35.jpg
         * type : 0
         * id : 9708038
         * ga_prefix : 030121
         * title : 一个接一个，漫威的这些梗我是快招架不住了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
