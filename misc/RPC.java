package aethereal;

import meteordevelopment.discordipc.DiscordIPC;
import meteordevelopment.orbit.EventHandler;

public final class RPC extends Module {
   private static final long field0005 = 1486856029206478990L;
   private static final int field1411 = 200;
   private static final String field1030 = "avatar";
   private final DiscordRichPresence field1631 = new DiscordRichPresence();
   private int field1539;
   private boolean field1735;

   public RPC() {
      super("RPC", ModuleCategory.field0776, "Discord integration");
      this.method1013("Отображает активность в Discord");
      this.field1539 = 0;
      this.field1735 = false;
      this.method2178(true);
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1735 = false;
      this.method1735();
   }

   private void method1735() {
      if (!this.field1735) {
         try {
            DiscordIPC.start(1486856029206478990L, null);
            this.field1631.setStart(System.currentTimeMillis() / 1000L);
            this.method1691();
            this.field1735 = true;
         } catch (Exception exception) {
         }
      }
   }

   @Override
   public void method2078() {
      try {
         DiscordIPC.stop();
      } catch (Exception exception) {
      }

      this.field1735 = false;
      super.method2078();
   }

   @EventHandler
   public void onClientTick(ClientTickEvent clienttickevent) {
      if (!this.field1735) {
         this.method1735();
      }

      if (this.field1539 > 0) {
         this.field1539--;
      } else {
         this.method1691();
         this.field1539 = 200;
      }
   }

   private void method1691() {
      ClientContext clientcontext = ArbuzClient.method2004().method1744();
      String s = clientcontext.method0557() + " | UID: " + clientcontext.method2048() + " | " + clientcontext.method1791();
      this.field1631.setLargeImage("avatar", s);
      this.field1631.setDetails(this.method1750());
      DiscordIPC.setActivity(this.field1631);
   }

   private String method1750() {
      if (field0796.method_1542()) {
         return "Singleplayer";
      } else {
         return field0796.method_1558() != null ? field0796.method_1558().field_3761 : "Main Menu";
      }
   }
}
