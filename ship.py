import pygame
class Ship():
    def __init__(self,ai_settings,screen):
        """initialize ship and position"""
        self.screen=screen
        self.ai_settings=ai_settings

        #load image and get 外接矩形
        self.image=pygame.image.load(r'E:/Game/images/ship.bmp')
        self.rect=self.image.get_rect()
        self.screen_rect=screen.get_rect()

        #put ship in the center
        self.rect.centerx=self.screen_rect.centerx
        self.rect.bottom=self.screen_rect.bottom

        #存储速度
        self.center=float(self.rect.centerx)

        #move sign
        self.moving_right=False
        self.moving_left = False

    def update(self):
        """根据标志调整飞船位置"""
        #更新center，而不是rect
        if self.moving_right and self.rect.right<self.screen_rect.right:
            self.center += self.ai_settings.ship_speed_factor
        if self.moving_left and self.rect.left>0:
            self.center -= self.ai_settings.ship_speed_factor
        #更新rect对象
        self.rect.centerx=self.center


    def blitme(self):
        """draw ship"""
        self.screen.blit(self.image,self.rect)