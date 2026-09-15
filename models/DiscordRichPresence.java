package aethereal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import meteordevelopment.discordipc.RichPresence;

public class DiscordRichPresence extends RichPresence {
   private String field0715;
   private String field0136;
   private String field1504;
   private String field1030;

   public void method1045(String var1, String var2) {
      this.field0715 = var1;
      this.field0136 = var2;
   }

   public void method0218(String var1, String var2) {
      this.field1504 = var1;
      this.field1030 = var2;
   }

   public JsonObject toJson() {
      JsonObject var1 = super.toJson();
      if (this.field0715 != null || this.field1504 != null) {
         JsonArray var2 = new JsonArray();
         if (this.field0715 != null && this.field0136 != null) {
            JsonObject var3 = new JsonObject();
            var3.addProperty("label", this.field0715);
            var3.addProperty("url", this.field0136);
            var2.add(var3);
         }

         if (this.field1504 != null && this.field1030 != null) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("label", this.field1504);
            var4.addProperty("url", this.field1030);
            var2.add(var4);
         }

         var1.add("buttons", var2);
      }

      return var1;
   }
}
